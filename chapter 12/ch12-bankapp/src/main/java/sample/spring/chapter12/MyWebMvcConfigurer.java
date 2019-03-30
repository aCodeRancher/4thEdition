package sample.spring.chapter12;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "sample.spring.chapter12.web")
public class MyWebMvcConfigurer implements WebMvcConfigurer {

     @Override
      public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
         configurer.enable();
     }

}
