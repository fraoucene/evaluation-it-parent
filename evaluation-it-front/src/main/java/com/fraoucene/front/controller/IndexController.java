package com.fraoucene.front.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class IndexController {


    public ModelAndView index() throws IOException {


        ModelAndView mav = new ModelAndView("index");

        String aboutMe = "je suis le plus fort";

        String msg = "Running IndexController.index() method";

        mav.addObject("msg", msg);
        mav.addObject("about", aboutMe);
        return mav;
    }

    /**
     *  http://localhost:8080/evaluation-it/create-category?title=JAVA
     *
     * @param title
     */

}
