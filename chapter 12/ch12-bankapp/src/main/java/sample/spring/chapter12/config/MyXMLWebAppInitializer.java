package sample.spring.chapter12.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyXMLWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup (final ServletContext inServletContext){
        final XmlWebApplicationContext theXmlWebApplicationContext =
                new XmlWebApplicationContext();

        theXmlWebApplicationContext.setConfigLocation("/WEB-INF/spring/bank-config.xml");
        inServletContext.addListener(new ContextLoaderListener(theXmlWebApplicationContext));
        theXmlWebApplicationContext.setServletContext(inServletContext);
        theXmlWebApplicationContext.refresh();
        theXmlWebApplicationContext.start();


        final DispatcherServlet theDispatcherServlet =
                new DispatcherServlet(theXmlWebApplicationContext);

        ServletRegistration.Dynamic theServletRegistration =
                inServletContext.addServlet("bankapp", theDispatcherServlet);
        theServletRegistration.setLoadOnStartup(1);
        theServletRegistration.addMapping("/");

    }
}
