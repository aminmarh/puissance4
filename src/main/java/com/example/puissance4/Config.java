package com.example.puissance4;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.InputStream;
import java.io.OutputStream;

@Configuration
public class Config {
    @Bean
    public InputStream getInputStream() {
        return System.in;
    }
    @Bean
    public OutputStream getOutputStream() {
        return System.out;
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("locale");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
