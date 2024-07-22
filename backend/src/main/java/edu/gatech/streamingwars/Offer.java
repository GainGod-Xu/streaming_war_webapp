package edu.gatech.streamingwars;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Entity
@Table(name= "offers")
class Offer{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String service;
    private String name;
    private String type;
    private int year;
    private int viewingPrice;

    Offer(){}
//offer movie
    Offer(String service, String name, String type, int year){
        this.service = service;
        this.name = name;
        this.type = type;
        this.year = year;
    }
//offer ppv
    Offer(String service, String name, String type, int year, int viewingPrice){
        this.service = service;
        this.name = name;
        this.type = type;
        this.year = year;
        this.viewingPrice = viewingPrice;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getService() {
        return service;
    }

    public int getViewingPrice() {
        return viewingPrice;
    }

    public void setViewingPrice(int viewingPrice) {
        this.viewingPrice = viewingPrice;
    }

}
