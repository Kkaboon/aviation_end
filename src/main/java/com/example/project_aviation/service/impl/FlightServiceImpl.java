package com.example.project_aviation.service.impl;

import com.example.project_aviation.dao.FlightRepository;
import com.example.project_aviation.domain.Flight;
import com.example.project_aviation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Object[]> findbyairportandtime(String dairport, String aairport, String date) {
        List<Object[]> list=flightRepository.bydeaandaraanddetime(dairport,aairport,date);
        return list;
    }

    @Override
    public List<Object[]> findbyflightnoandtime(Integer flightno,String date) {
        List<Object[]> list=flightRepository.byfnoanddetime(flightno,date);
        return list;
    }

    @Override
    public String seatleft(Integer flightno) {
        boolean flag=false;
        try {
            flightRepository.seatleft(flightno);
            flag=true;
        }catch (Exception e){
            System.out.println("购票失败");
        }
        return flag==true?"success":"failed";
    }

    @Override
    public List<Flight> findall() {
        List<Flight> flights=flightRepository.findAll();
        return flights;
    }

    @Override
    public String addone(Flight flight) {
        boolean flag=false;
        try {
            flightRepository.save(flight);
            flag=true;
        }catch (Exception e){
            System.out.println("添加航班失败");
        }
        return flag==true?"success":"failed";
    }
}
