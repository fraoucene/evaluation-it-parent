package org.resthub.web.springmvc.router;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;


/**
 * Classe abstraire pour aider à resoudre les URI du router SpringMVC.
 *
 * @param <T> - une implementation de ReverseUri.Builder
 */
public abstract class ReverseUri<T extends ReverseUri.Builder> {

    /**
     * Constructeur pour initialiser les paramètres du Builder.
     *
     * @param router - un router SpringMVC
     * @param action - le bean et la methode pour résoudre l'URI
     */
    public ReverseUri(RouterWrapper router, String action) {
        this.router = router;
        this.action = action;
    }

    /**
     * Methode abstraite pour construire un nouveau Builder.
     *
     * @return une classe qui implemente ReverseUri.Builder
     */
    public abstract T build();

    protected final RouterWrapper router;
    protected final String action;


    /**
     * Reverse uri builder with a fluent API.
     *
     * @param <T> a ReverseUri.Builder implentor.
     */
    public static class Builder<T extends Builder> {

        public T noContext() {
            withContext = false;
            return (T) this;
        }

        public T absolute() {
            isAbsolute = true;
            return (T) this;
        }

        public T redirect() {
            useRedirect = true;
            return (T) this;
        }

        public T useQueryString() {
            useQueryString = true;
            return (T) this;
        }

        public String uri() {
            StringBuilder uri = new StringBuilder();

            if (useQueryString) {
                HTTPRequestAdapter currentRequest = HTTPRequestAdapter.getCurrent();
                if (!Strings.isNullOrEmpty(currentRequest.getQueryString())) {
                    String[] params = currentRequest.getQueryString().split("&");
                    for (String param : params) {
                        String[] pairs = param.split("=");
                        this.params.put(pairs[0], pairs.length > 1 ? pairs[1] : "");
                    }
                }
            }

            if (useRedirect) {
                uri.append("redirect:" + router.noCpReverseFragment(action, anchor, params).toString());
            } else if (isAbsolute) {
                Router.ActionDefinition actionDefinition = router.reverseFragment(action, anchor, params);
                actionDefinition.absolute();
                uri.append(actionDefinition.toString());
            } else if (withContext) {
                uri.append(router.reverseFragment(action, anchor, params).toString());
            } else {
                uri.append(router.noCpReverseFragment(action, anchor, params).toString());
            }

            return uri.toString();
        }


        public Builder(RouterWrapper router, String action) {
            this.router = router;
            this.action = action;
            this.params = new HashMap();
        }

        protected T withParam(String name, Object value) {
            this.params.put(name, value);
            return (T) this;
        }

        protected T withAnchor(String anchor) {
            this.anchor = anchor;
            return (T) this;
        }

        protected boolean withContext = true;
        protected boolean isAbsolute = false;
        protected boolean useRedirect = false;
        protected boolean useQueryString = false;
        protected String anchor;

        private final RouterWrapper router;
        private final String action;
        private final Map<String, Object> params;
    }

}
