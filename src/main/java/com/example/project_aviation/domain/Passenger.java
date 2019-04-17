package com.example.project_aviation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Passenger")
public class Passenger {
    @Id
    @Column(name = "identity_no")
    private String identityno;

    @Column
    private String name;


    @Column
    private String sex;

    @Column(unique = true)
    private String telephone;

    @Column
    private String address;

    @Column
    private String password;

    @Column
    private Boolean isAd;


    public Boolean getAd() {
        return isAd;
    }

    public void setAd(Boolean ad) {
        isAd = ad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
