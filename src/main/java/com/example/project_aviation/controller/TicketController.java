package com.example.project_aviation.controller;

import com.example.project_aviation.domain.Ticket;
import com.example.project_aviation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticket", produces = {"application/json;charset=UTF-8"})
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/findall")
    public List<Object[]> findall() {
        return ticketService.findall();
    }

    @GetMapping("/findown")
    public List<Object[]> findown(String idno) {
        return ticketService.findallbyown(idno);
    }

    @GetMapping("/findorder")
    public List<Object[]> findorder(Integer fno, String idno) {
        return ticketService.findallbyfnoandino(fno, idno);
    }

    @PostMapping("/addone")
    public String addOne(String idno,Integer fno) {
        return ticketService.addone(idno, fno);
    }
}
