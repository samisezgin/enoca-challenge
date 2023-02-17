package com.enoca.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    private final ModelMapper modelMapper=new ModelMapper();

    @Bean
    public ModelMapper getModelMapper()
    {
        return modelMapper;
    }
}
