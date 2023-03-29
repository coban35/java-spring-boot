package com.app.drone.entity;

import javax.persistence.*;

@Entity
@Table(name = "DRONE")
public class Drone {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "MARK", length = 100)
    private String mark;

    @Column(name = "MODEL", length = 100)
    private String model;

    @Column(name = "PRICE")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
