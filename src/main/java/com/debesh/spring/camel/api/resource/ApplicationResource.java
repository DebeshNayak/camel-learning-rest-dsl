package com.debesh.spring.camel.api.resource;

import com.debesh.spring.camel.api.service.OrderService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

    @Autowired
    private OrderService service;

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

        rest()
                .get("/hello-world")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(constant("Welcome to camel rest api"));

        rest()
                .get("/getOrders")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(() -> service.getOrders());

    }

}
