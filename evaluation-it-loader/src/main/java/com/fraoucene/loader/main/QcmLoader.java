package com.fraoucene.loader.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fraoucene.evaluation.it.api.model.Categories;
import com.fraoucene.evaluation.it.api.services.CategoriesService;
import com.fraoucene.evaluation.it.dao.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by fraoucene on 09/11/2015.
 */


public class QcmLoader {



    @Value("${qcm.json.path}")
    private String qcmJsonPath;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CategoriesRepository categoryRepository;

    public static  void main(String[] args) throws Exception {
        //ObjectMapper mapper = new ObjectMapper();
       // Map<String, List<Map<String,Object>>> qcmJsonData = mapper.readValue(new File(qcmJsonPath), Map.class);
        String s = "JAVA";
        String s2 = "ANgularJS";
        Categories c = new Categories(s);
        Categories c2 = new Categories(s2);
    }


}
