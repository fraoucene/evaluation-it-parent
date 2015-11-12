package com.fraoucene.front.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class IndexController {


    @Value("${qcm.json.path}")
    private String qcmJsonPath;

    public ModelAndView index() throws IOException {


        ModelAndView mav = new ModelAndView("index");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File("C:/Users/fraoucene/Desktop/workspace/config/data/newQcm.json"), Map.class);

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
