package sample.spring.chapter12;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup (final ServletContext container){
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebContextConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("bankapp", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
}