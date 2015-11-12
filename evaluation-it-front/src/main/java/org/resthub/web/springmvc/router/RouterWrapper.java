package org.resthub.web.springmvc.router;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import jregex.Matcher;
import org.resthub.web.springmvc.router.exceptions.NoHandlerFoundException;
import org.resthub.web.springmvc.router.exceptions.RouteFileParsingException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple wrapper de org.resthub.web.springmvc.router.Router qui n'utilise pas de méthodes statiques, et est donc
 * testable.
 * <p/>
 * Deplus, cela corrige le problème du reverse depuis n'importe quel URL.
 */
public class RouterWrapper {

    /**
     * Reverse de la route avec le context path
     *
     * @param action la reference du handler
     * @return un objet contenant les informations de la route, avec le context path
     * @see org.resthub.web.springmvc.router.Router#reverse(String)
     */
    public Router.ActionDefinition reverse(String action) {
        return fixReverse(action, new HashMap<String, Object>(16), true, null);
    }

    /**
     * Reverse de la route avec le context path
     *
     * @param action la reference du handler
     * @param args   les arguments pour compléter la route
     * @return un objet contenant les informations de la route, avec le context path
     * @see Router#reverse(String,
     * Map<String,Object>)
     */
    public Router.ActionDefinition reverse(String action, Map<String, Object> args) {
        return fixReverse(action, args, true, null);
    }

    /**
     * Reverse de la route avec le context path
     *
     * @param action L'action à reverser
     * @param params Tableau des paramètres. Index impair : nom du paramètre. Index pair: valeur du paramètre
     * @return un objet contenant les informations de la route, avec le context path
     */
    public Router.ActionDefinition reverse(String action, Object... params) {
        HashMap<String, Object> args = argsToMap(params);
        return fixReverse(action, args, true, null);
    }

    /**
     * @param action   L'action à reverser
     * @param fragment Un fragment (#anchor) à ajouter à l'URL
     * @param args     Tableau des paramètres. Index impair : nom du paramètre. Index pair: valeur du paramètre
     * @return un objet contenant les informations de la route, avec le context path
     */
    public Router.ActionDefinition reverseFragment(String action, String fragment, Map<String, Object> args) {
        return fixReverse(action, args, true, fragment);
    }

    /**
     * Reverse route without context
     *
     * @param action controller method to map
     * @param args   map of parameters
     * @return an object with URL infos, sans le context path
     */
    public Router.ActionDefinition noCpReverse(String action, Map<String, Object> args) {
        return fixReverse(action, args, false, null);
    }

    /**
     * Reverse de la route sans le context path
     *
     * @param action L'action à reverser
     * @param params Tableau des paramètres. Index impair : nom du paramètre. Index pair: valeur du paramètre
     * @return un objet contenant les informations de la route, sans le context path
     */
    public Router.ActionDefinition noCpReverse(String action, Object... params) {
        HashMap<String, Object> args = argsToMap(params);
        return fixReverse(action, args, false, null);
    }

    /**
     * @param action   L'action à reverser
     * @param fragment Un fragment (#anchor) à ajouter à l'URL
     * @param args     map of parameters
     * @return un objet contenant les informations de la route, sans le context path
     */
    public Router.ActionDefinition noCpReverseFragment(String action, String fragment, Map<String, Object> args) {
        return fixReverse(action, args, false, fragment);
    }

    private HashMap<String, Object> argsToMap(Object[] params) {
        Preconditions.checkArgument(params == null || params.length % 2 == 0);
        HashMap<String, Object> args = new HashMap();
        for (int i = 0; i < params.length; i += 2) {
            String key = null == params[i] ? "" : params[i].toString();
            String value = null == params[i + 1] ? "" : params[i + 1].toString();

            if (!Strings.isNullOrEmpty(key) && !Strings.isNullOrEmpty(value)) {
                args.put(key, value);
            }
        }
        return args;
    }

    /**
     * Copier/Coller de l'implémentation d'origine au delta près que celle là corrige le bug du reverse
     *
     * @param action
     * @param args
     * @param withContextPath true si on veut prépender le context path à l'URL
     * @return
     */
    private static Router.ActionDefinition fixReverse(String action, Map<String, Object> args, boolean withContextPath, String fragment) {

        HTTPRequestAdapter currentRequest = HTTPRequestAdapter.getCurrent();

        Map<String, Object> argsbackup = new HashMap(args);
        for (Router.Route route : Router.routes) {
            if (route.actionPattern != null) {
                Matcher matcher = route.actionPattern.matcher(action);
                if (matcher.matches()) {
                    for (String group : route.actionArgs) {
                        String v = matcher.group(group);
                        if (v == null) {
                            continue;
                        }
                        args.put(group, v.toLowerCase());
                    }
                    List<String> inPathArgs = new ArrayList(16);
                    boolean allRequiredArgsAreHere = true;
                    // les noms de parametres matchent ils ?
                    for (Router.Route.Arg arg : route.args) {
                        inPathArgs.add(arg.name);
                        Object value = args.get(arg.name);
                        if (value == null) {
                            // This is a hack for reverting on hostname that are a regex expression.
                            // See [#344] for more into. This is not optimal and should retough. However,
                            // it allows us to do things like {(.*)}.domain.com
                            String host = route.host.replaceAll("\\{", "").replaceAll("\\}", "");
                            if (host.equals(arg.name) || host.matches(arg.name)) {
                                args.put(arg.name, "");
                                value = "";
                            } else {
                                allRequiredArgsAreHere = false;
                                break;
                            }
                        } else {
                            if (value instanceof List<?>) {
                                @SuppressWarnings("unchecked")
                                List<Object> l = (List<Object>) value;
                                value = l.get(0);
                            }
                            if (!value.toString().startsWith(":") && !arg.constraint.matches(value.toString())) {
                                allRequiredArgsAreHere = false;
                                break;
                            }
                        }
                    }
                    // les parametres codes en dur dans la route matchent-ils ?
                    for (String staticKey : route.staticArgs.keySet()) {
                        if (staticKey.equals("format")) {
                            if (!currentRequest.format.equals(route.staticArgs.get("format"))) {
                                allRequiredArgsAreHere = false;
                                break;
                            }
                            continue; // format is a special key
                        }
                        if (!args.containsKey(staticKey) || (args.get(staticKey) == null)
                                || !args.get(staticKey).toString().equals(route.staticArgs.get(staticKey))) {
                            allRequiredArgsAreHere = false;
                            break;
                        }
                    }
                    if (allRequiredArgsAreHere) {
                        StringBuilder queryString = new StringBuilder();
                        String path = route.path;
                        //add contextPath and servletPath if set in the current request
//                        if (currentRequest != null) {

                        // FIXME : soumettre un patch à l'auteur ?
//                            if (!currentRequest.servletPath.isEmpty() && !currentRequest.servletPath.equals("/")) {
//                                String servletPath = currentRequest.servletPath;
//                                path = (servletPath.startsWith("/") ? servletPath : "/" + servletPath) + path;
//                            }
//
                        if (withContextPath && !currentRequest.contextPath.isEmpty() && !currentRequest.contextPath.equals("/")) {
                            String contextPath = currentRequest.contextPath;
                            path = (contextPath.startsWith("/") ? contextPath : "/" + contextPath) + path;
                        }
//                        }
                        String host = route.host;
                        if (path.endsWith("/?")) {
                            path = path.substring(0, path.length() - 2);
                        }
                        for (Map.Entry<String, Object> entry : args.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (inPathArgs.contains(key) && value != null) {
                                if (List.class.isAssignableFrom(value.getClass())) {
                                    @SuppressWarnings("unchecked")
                                    List<Object> vals = (List<Object>) value;
                                    try {
                                        path = path.replaceAll("\\{(<[^>]+>)?" + key + "\\}", URLEncoder.encode(vals.get(0).toString().replace("$", "\\$"), "utf-8"));
                                    } catch (UnsupportedEncodingException e) {
                                        throw new RouteFileParsingException("RouteFile encoding exception", e);
                                    }
                                } else {
                                    try {
                                        path = path.replaceAll("\\{(<[^>]+>)?" + key + "\\}", URLEncoder.encode(value.toString().replace("$", "\\$"), "utf-8"));
                                        host = host.replaceAll("\\{(<[^>]+>)?" + key + "\\}", URLEncoder.encode(value.toString().replace("$", "\\$"), "utf-8"));
                                    } catch (UnsupportedEncodingException e) {
                                        throw new RouteFileParsingException("RouteFile encoding exception", e);
                                    }
                                }
                            } else if (route.staticArgs.containsKey(key)) {
                                // Do nothing -> The key is static
                            } else if (value != null) {
                                if (List.class.isAssignableFrom(value.getClass())) {
                                    @SuppressWarnings("unchecked")
                                    List<Object> vals = (List<Object>) value;
                                    for (Object object : vals) {
                                        try {
                                            queryString.append(URLEncoder.encode(key, "utf-8"));
                                            queryString.append("=");
                                            if (object.toString().startsWith(":")) {
                                                queryString.append(object.toString());
                                            } else {
                                                queryString.append(URLEncoder.encode(object.toString() + "", "utf-8"));
                                            }
                                            queryString.append("&");
                                        } catch (UnsupportedEncodingException ex) {
                                        }
                                    }
//                                } else if (value.getClass().equals(Default.class)) {
//                                    // Skip defaults in queryString
                                } else {
                                    try {
                                        queryString.append(URLEncoder.encode(key, "utf-8"));
                                        queryString.append("=");
                                        if (value.toString().startsWith(":")) {
                                            queryString.append(value.toString());
                                        } else {
                                            queryString.append(URLEncoder.encode(value.toString() + "", "utf-8"));
                                        }
                                        queryString.append("&");
                                    } catch (UnsupportedEncodingException ex) {
                                    }
                                }
                            }
                        }
                        String qs = queryString.toString();
                        if (qs.endsWith("&")) {
                            qs = qs.substring(0, qs.length() - 1);
                        }
                        Router.ActionDefinition actionDefinition = new Router.ActionDefinition();
                        actionDefinition.url = qs.length() == 0 ? path : path + "?" + qs;
                        actionDefinition.method = route.method == null || route.method.equals("*") ? "GET" : route.method.toUpperCase();
                        actionDefinition.star = "*".equals(route.method);
                        actionDefinition.action = action;
                        actionDefinition.args = argsbackup;
                        actionDefinition.host = host;
                        if (!Strings.isNullOrEmpty(fragment)) {
                            actionDefinition.url += "#" + fragment;
                        }


                        return actionDefinition;
                    }
                }
            }
        }
        throw new NoHandlerFoundException(action, args);
    }


}
