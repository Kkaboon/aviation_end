package com.example.project_aviation.domain;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
//@IdClass(PrimaryKey.class)
public class Ticket {
    @Id
    @Column(name = "ticket_no")
    private Integer ticketno;

    @Column(name = "identity_no")
    private String identityno;

    @Column(nullable = false,name = "flight_no")
    private Integer flightno;

    @Column(nullable = false,name = "seat_no")
    private Integer seatno;

    public Integer getTicket_no() {
        return ticketno;
    }

    public void setTicket_no(int ticket_no) {
        this.ticketno = ticket_no;
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno;
    }

    public Integer getFlightno() {
        return flightno;
    }

    public void setFlightno(int flightno) {
        this.flightno = flightno;
    }

    public Integer getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }
}
