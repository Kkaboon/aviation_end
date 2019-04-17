package com.example.project_aviation.service;

import com.example.project_aviation.domain.Ticket;

import java.util.List;

public interface TicketService {
    List<Object[]> findall();

    List<Object[]> findallbyown(String identityno);

    /*List<Object[]> findallbyfno(Integer fno);

    List<Object[]> findallbyino(String ino);*/

    List<Object[]> findallbyfnoandino(Integer fno,String ino);

    String addone(String idno,Integer fno);
}
