package com.example.project_aviation.service;

import com.example.project_aviation.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    List<Order> findByIdentitynoandflightno(String ino,Integer fno);

    String addOrder(Order order);
}
