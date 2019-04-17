package com.example.project_aviation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @Column(name = "flight_no")
    private Integer flightno;

    @Column(nullable = false,name = "departure_airport")
    private String departureairport;

    @Column(nullable = false,name = "arrival_airport")
    private String arrivalairport;

    @Column(nullable = false,name = "departure_time")
    private Date departuretime;

    @Column(nullable = false,name = "plane_no")
    private Integer planeno;

    @Column(nullable = false)
    private Integer price;

    public Integer getFlightno() {
        return flightno;
    }

    public void setFlightno(int flightno) {
        this.flightno = flightno;
    }

    public String getDepartureairport() {
        return departureairport;
    }

    public void setDepartureairport(String departureairport) {
        this.departureairport = departureairport;
    }

    public String getArrivalairport() {
        return arrivalairport;
    }

    public void setArrivalairport(String arrivalairport) {
        this.arrivalairport = arrivalairport;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Integer getPlaneno() {
        return planeno;
    }

    public void setPlaneno(int planeno) {
        this.planeno = planeno;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
