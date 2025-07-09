package com.thales.bffagendador_tarefas.InfraStructure.client.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FengConfig {

    @Bean
    public FeignError feignError(){
        return new FeignError();
    }
}
