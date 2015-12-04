package com.fraoucene.front.controller;



import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private CategoriesService categoriesService;

    public ModelAndView index() throws IOException {

        Iterable<Categories> allCategories = categoriesService.getAllCategories();

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("categories", allCategories);
        String aboutMe = "je suis le plus fort";


        String msg = "Running IndexController.index() method";

        mav.addObject("msg", msg);
        mav.addObject("about", aboutMe);
        return mav;
    }

}
