package com.uds.horbac.configs;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {

   @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
    }
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {

       registry
               .addResourceHandler("swagger-ui.html")
               .addResourceLocations("classpath:/META-INF/resources/");

       registry
               .addResourceHandler("/webjars/**")
               .addResourceLocations("classpath:/META-INF/resources/webjars/");
   }
   
   @Bean
   public FilterRegistrationBean corsFilter() {
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
       source.registerCorsConfiguration("/**", config);
       FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
       bean.setOrder(0);
       return bean;
   }
    
}