package com.example.project_aviation.dao;

import com.example.project_aviation.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAll();
    List<Order> findByIdentityno(String identityno);

    List<Order> findByFlightno(Integer flightno);

    List<Order> findByIdentitynoAndFlightno(String identityno,Integer flightno );

}
