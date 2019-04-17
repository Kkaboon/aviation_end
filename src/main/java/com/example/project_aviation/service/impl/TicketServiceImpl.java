package com.example.project_aviation.service.impl;

import com.example.project_aviation.dao.FlightRepository;
import com.example.project_aviation.dao.TicketRepository;
import com.example.project_aviation.domain.Ticket;
import com.example.project_aviation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    FlightRepository flightRepository;
    @Override
    public List<Object[]> findall() {
        List<Object[]> ticketList=ticketRepository.findAllTickets();
        return ticketList;
    }

    /*@Override
    public List<Ticket> findallbyfno(Integer fno) {
        List<Ticket> ticketList=ticketRepository.findAllByFlightno(fno);
        return ticketList;
    }*/

    @Override
    public List<Object[]> findallbyown(String ino) {
        List<Object[]> ticketList=ticketRepository.findAllOwn(ino);
        return ticketList;
    }

    @Override
    public List<Object[]> findallbyfnoandino(Integer fno,String ino) {
        List<Object[]> ticketList;
        if (fno==0&&ino.equals("0")){
            ticketList=ticketRepository.findAllTickets();
        }
        else if (fno==0){
            ticketList=ticketRepository.findallIdno(ino);
        }
        else if (ino.equals("0")){
            ticketList=ticketRepository.findallfno(fno);
        }
        else
            ticketList=ticketRepository.findallfnoandidno(fno, ino);
        return ticketList;
    }

    @Override
    public String addone(String idno,Integer fno) {
        boolean flag=false;
        try {
            ticketRepository.addone(idno,fno);
            try {
                flightRepository.seatleft(fno);
                flag=true;
            }catch (Exception e){
                System.out.println("无空余座位！");
            }
        }catch (Exception e){
            System.out.println("购票失败！");
            System.out.println(e);
        }
        return flag==true?"success":"failed";
    }
}
