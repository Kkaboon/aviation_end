package com.example.project_aviation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plane")
public class Plane {
    @Id
    @Column(name = "plane_no")
    private Integer planeno;

    @Column(nullable = false,name = "seats_total")
    private Integer seatstotal;

    @Column(nullable = false,name = "airline_no")
    private Integer airlineno;

    public Integer getPlaneno() {
        return planeno;
    }

    public void setPlaneno(Integer planeno) {
        this.planeno = planeno;
    }

    public Integer getSeatstotal() {
        return seatstotal;
    }

    public void setSeatstotal(Integer seatstotal) {
        this.seatstotal = seatstotal;
    }

    public Integer getAirlineno() {
        return airlineno;
    }

    public void setAirlineno(Integer airlineno) {
        this.airlineno = airlineno;
    }
}
