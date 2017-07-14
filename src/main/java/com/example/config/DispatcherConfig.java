package com.example.config;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.xml.ws.Endpoint;

/**
 * Created by ThinkPad on 2017/7/14.
 */
@Configuration
public class DispatcherConfig {
    @Autowired
    private  UserService userService;
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/");
        return registration;
    }
    @Bean
    public ServletRegistrationBean cxfDispatcher() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),userService);
        endpoint.publish("/user");
        return endpoint;
    }
}
