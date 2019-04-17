package com.example.project_aviation.controller;

import com.example.project_aviation.dao.PassengerRepository;
import com.example.project_aviation.domain.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

@RestController
@RequestMapping(value = "/passenger", produces = {"application/json;charset=UTF-8"})
public class PassengerController {
    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping("/findall")
    public List<Object[]> findall(){
        List<Object[]> passengerList=passengerRepository.findALL();
        return passengerList;
    }

    @GetMapping("/ispassengerexist")
    public String ispassengerexist(String telephone) {
        Passenger passenger = passengerRepository.findByTelephone(telephone);
        return passenger == null ? "notfound" : "exist";
    }

    @GetMapping("/getpassenger")
    public Passenger getPassenger(String telephone) {
        Passenger passenger = passengerRepository.findByTelephone(telephone);
        return passenger == null ? null : passenger;
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody Passenger passenger) {
        boolean flag = false;
        try {
            passengerRepository.save(passenger);
            flag = true;
        } catch (Exception e) {
            System.out.println("保存失败");
        }
        return flag == true ? "success" : "failed";
    }

    @GetMapping(value = "/getpassword")
    public String getpassword(String identityno) {
        Passenger passenger = passengerRepository.findByIdentityno(identityno);
        String ps = passenger.getPassword();
        return ps;
    }

    @GetMapping(value = "/getisAd")
    public Boolean getisAd(String identityno) {
        Passenger passenger = passengerRepository.findByIdentityno(identityno);
        return passenger.getAd();
    }

    @PostMapping(value = "/updatePassenger")
    public String updatePassenger(@RequestBody Passenger passenger) {
        boolean flag = false;
        String idno = passenger.getIdentityno();
        String pass = passenger.getPassword();
        String add = passenger.getAddress();
        try {
            passengerRepository.updatePassenger(idno, pass, add);
            flag = true;
        } catch (Exception e) {
            System.out.println("update failed");
        }
        return flag == true ? "success" : "failed";
    }
}
