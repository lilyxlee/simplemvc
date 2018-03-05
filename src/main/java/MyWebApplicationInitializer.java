import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


/**
 * Equivalent of web.xml.
 *
 * Spring mvc bootstrap process:
 * 1. Servlet container calls an implementation of ServletContainerInitializer. In the case of SpringMVC, it is SpringServletContainerInitializer
 * 2. SpringServletContainerInitializer calls an implementation of WebApplicationInitializer because it is annotated with @HandlesTypes({WebApplicationInitializer.class})
 * 3. This method creates Spring ApplicationContext which is used by the DispatcherServlet.
 * 4. This DispacherServlet is then registered in the container.
 *
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {


    public void onStartup(ServletContext servletCxt) {
        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
    }
}
