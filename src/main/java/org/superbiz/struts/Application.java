package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public UserService userServiceBean() {
//        return new UserServiceImpl();
//    }

    @Bean
    public FilterRegistrationBean filterDispatcherBean() {

        FilterRegistrationBean fb = new FilterRegistrationBean(
                new FilterDispatcher()
        );
        fb.setOrder(3);
        fb.setUrlPatterns(Arrays.asList("/*"));
        fb.addInitParameter("actionPackages", "com.lq");

        return fb;
    }

    @Bean
    public FilterRegistrationBean actionContextCleanUpBean() {

        FilterRegistrationBean fb = new FilterRegistrationBean(
                new ActionContextCleanUp()
        );
        fb.setOrder(1);
        fb.setUrlPatterns(Arrays.asList("/*"));

        return fb;
    }

    @Bean
    public FilterRegistrationBean pageFilterBean() {

        FilterRegistrationBean fb = new FilterRegistrationBean(
                new PageFilter()
        );
        fb.setOrder(2);
        fb.setUrlPatterns(Arrays.asList("/*"));

        return fb;
    }
}
