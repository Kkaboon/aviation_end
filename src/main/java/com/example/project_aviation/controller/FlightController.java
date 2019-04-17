package com.example.project_aviation.controller;

import com.example.project_aviation.domain.Flight;
import com.example.project_aviation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/flight", produces = { "application/json;charset=UTF-8" })
public class FlightController {
    //航班号+出发时间
    //出发机场+到达机场+出发时间
    @Autowired
    FlightService flightService;

    @GetMapping("/findbyairportandtime")
    public List<Object[]> findbyairportandtime(String da,String aa, String date){
        List<Object[]> flights=flightService.findbyairportandtime(da,aa,date);
        return flights;
    }

    @GetMapping("/findbyfnoandtime")
    public List<Object[]> findbyfnoandtime(Integer fno,String date) throws ParseException {
       /* SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        Date date1=simpleDateFormat.parse(date);
        System.out.println(date1);*/
        System.out.println(date);
        List<Object[]> list=flightService.findbyflightnoandtime(fno,date);
        return list;
    }

    @GetMapping("/findall")
    public List<Flight> findall(){
        return flightService.findall();
    }

    @PostMapping("/addOne")
    public String addOne(@RequestBody Flight flight){
        return flightService.addone(flight);
    }
}
