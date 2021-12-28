package com.debesh.spring.camel.api.service;

import com.debesh.spring.camel.api.dto.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> list = new ArrayList<>();

    @PostConstruct
    public void initDb() {
        list.add(new Order(67, "Mobile", 5000));
        list.add(new Order(56, "Book", 4000));
        list.add(new Order(45, "AC", 15000));
        list.add(new Order(14, "Shoes", 2000));
    }

    public Order addOrder(Order order) {
        list.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return list;
    }

}
