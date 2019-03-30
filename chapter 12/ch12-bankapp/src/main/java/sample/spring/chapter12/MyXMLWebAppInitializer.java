package sample.spring.chapter12;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyXMLWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup (ServletContext container)  {
         XmlWebApplicationContext   appContext = new XmlWebApplicationContext();

         appContext.setConfigLocation("classpath*:/META-INF/spring/applicationContext.xml");
        container.addListener(new ContextLoaderListener(appContext));
        appContext.setServletContext(container);
         appContext.refresh();
         appContext.start();
        DispatcherServlet theDispatcherServlet = new DispatcherServlet(appContext);
        theDispatcherServlet.setContextConfigLocation("/WEB-INF/spring/bankapp-servlet.xml");
        ServletRegistration.Dynamic theServletRegistration =
               container.addServlet("bankapp", theDispatcherServlet);

        theServletRegistration.setLoadOnStartup(1);
        theServletRegistration.addMapping("/");


    }
}
