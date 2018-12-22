package fr.laerce.cinema.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/images/**",
                "/sass/**",
                "/fonts/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "/webjars/",
                        "classpath:/static/images/",
                        "classpath:/static/sasss/",
                        "classpath:/static/fonts/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }
}