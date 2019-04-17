package com.example.project_aviation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Airline")
public class Airline {
    @Id
    @Column(name = "airline_no")
    private Integer airlineno;

    @Column(nullable = false,name = "airline_name")
    private String airlinename;

    public Integer getAirlineno() {
        return airlineno;
    }

    public void setAirlineno(int airlineno) {
        this.airlineno = airlineno;
    }

    public String getAirlinename() {
        return airlinename;
    }

    public void setAirlinename(String airlinename) {
        this.airlinename = airlinename;
    }
}
