package com.example.project_aviation.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderDetail")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_no")
    private Integer orderno;

    @Column(name = "identity_no")
    private String identityno;

    @Column(name = "flight_no")
    private Integer flightno;

    @Column
    private Date orderdate;

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
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

    public void setFlightno(Integer flightno) {
        this.flightno = flightno;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}
