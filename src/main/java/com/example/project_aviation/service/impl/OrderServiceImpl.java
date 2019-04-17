package com.example.project_aviation.service.impl;

import com.example.project_aviation.dao.FlightRepository;
import com.example.project_aviation.dao.OrderRepository;
import com.example.project_aviation.domain.Order;
import com.example.project_aviation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    FlightRepository flightRepository;
    @Override
    public List<Order> findAll() {
        List<Order> orderList=orderRepository.findAll();
        return orderList;
    }

    @Override
    public List<Order> findByIdentitynoandflightno(String ino, Integer fno) {
        List<Order> orderList;
        if (ino==null){
            orderList=orderRepository.findByFlightno(fno);
        }
        else if (fno==null){
            orderList=orderRepository.findByIdentityno(ino);
        }else {
            orderList=orderRepository.findByIdentitynoAndFlightno(ino,fno);
        }
        return orderList;
    }

    @Override
    public String addOrder(Order order) {
        boolean flag=false;
        try {
            orderRepository.save(order);
            try {
                Integer integer=order.getFlightno();
                flightRepository.seatleft(integer);
                flag=true;
            }catch (Exception e){
                System.out.println("无空余座位！");
            }
        }catch (Exception e){
            System.out.println("购票失败！");
        }
        return flag==true?"success":"failed";
    }
}
