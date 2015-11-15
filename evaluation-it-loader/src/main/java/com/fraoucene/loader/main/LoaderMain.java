package com.fraoucene.loader.main;

import com.fraoucene.loader.spring.SpringConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Created by fraoucene on 09/11/2015.
 */


public class LoaderMain {

    private static final Logger LOG = LoggerFactory.getLogger(LoaderMain.class);


    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext context
                    = new AnnotationConfigApplicationContext(SpringConfig.class);
            Loader loader = context.getBean(Loader.class);

            loader.load();

        } catch (Exception ex) {
            LOG.error("Global error catched", ex);
            System.exit(30);
        }
    }


}
