package com.fraoucene.loader.spring;

import com.fraoucene.loader.main.Loader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * Created by fraoucene on 13/11/2015.
 */

@Configuration
@ComponentScan("com.fraoucene.evaluation")
@ImportResource("classpath:/spring/context-loader.xml")
public class SpringConfig {



    @Value("${qcm.json.path}")
    private String qcmJsonPath;

    @Bean
    public Loader getLoader() {
        return new Loader(qcmJsonPath);
    }

}
