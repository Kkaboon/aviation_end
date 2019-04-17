package com.example.project_aviation.dao;

import com.example.project_aviation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(value = "select p.name,t.identity_no,f.departure_time,t.ticket_no,t.flight_no,f.price " +
            "from flight f,ticket t,passenger p " +
            "where t.identity_no=p.identity_no and " +
            "t.flight_no=f.flight_no",nativeQuery = true)
    List<Object[]> findAllTickets();

    @Query(value = "select t.ticket_no,t.flight_no,f.departure_time,f.departure_airport,f.arrival_airport,f.price from ticket t,flight f " +
            "where t.identity_no=:identityno and " +
            "t.flight_no=f.flight_no",nativeQuery = true)
    List<Object[]> findAllOwn(@Param("identityno") String identityno);

    @Query(value = "select p.name,t.identity_no,f.departure_time,t.ticket_no,t.flight_no,f.price " +
            "from flight f,ticket t,passenger p " +
            "where t.identity_no=:identityno and " +
            "t.identity_no=p.identity_no and " +
            "t.flight_no=f.flight_no",nativeQuery = true)
    List<Object[]> findallIdno(@Param("identityno") String indentityno);

    @Query(value = "select p.name,t.identity_no,f.departure_time,t.ticket_no,t.flight_no,f.price " +
            "from flight f,ticket t,passenger p " +
            "where t.flight_no=:flightno and " +
            "t.identity_no=p.identity_no and " +
            "t.flight_no=f.flight_no",nativeQuery = true)
    List<Object[]> findallfno(@Param("flightno") Integer flightno);

    @Query(value = "select p.name,t.identity_no,f.departure_time,t.ticket_no,t.flight_no,f.price " +
            "from flight f,ticket t,passenger p " +
            "where t.flight_no=:flightno and " +
            "t.identity_no=:identityno and " +
            "t.identity_no=p.identity_no and " +
            "t.flight_no=f.flight_no",nativeQuery = true)
    List<Object[]> findallfnoandidno(@Param("flightno") Integer flightno,@Param("identityno") String identityno);

    @Transactional
    @Modifying
    @Query(value = "insert into ticket(identity_no, flight_no) values (:identityno,:flightno)",nativeQuery = true)
    int addone(@Param("identityno") String identityno,@Param("flightno") Integer flightno);
}
