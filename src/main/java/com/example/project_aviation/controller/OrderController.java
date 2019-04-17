package com.example.project_aviation.controller;

import com.example.project_aviation.dao.OrderRepository;
import com.example.project_aviation.domain.Order;
import com.example.project_aviation.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/findall")
    public List<Order> findall(){
        return orderService.findAll();
    }

    @GetMapping("/findbyinoandfno")
    public List<Order> findbyinoandfno(String ino,Integer fno){
        return orderService.findByIdentitynoandflightno(ino,fno);
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
}
