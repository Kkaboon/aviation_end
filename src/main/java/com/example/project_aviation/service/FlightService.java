package com.example.project_aviation.service;

import com.example.project_aviation.domain.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Object[]> findbyairportandtime(String dairport,String aairport,String date);
    List<Object[]> findbyflightnoandtime(Integer flightno,String date);
    String seatleft(Integer flightno);
    List<Flight> findall();
    String addone(Flight flight);
}
