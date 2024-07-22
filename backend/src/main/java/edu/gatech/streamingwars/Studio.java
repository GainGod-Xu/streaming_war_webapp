package edu.gatech.streamingwars;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name= "studios")
class Studio{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String shortName;
    private String longName;
    private int currentMonthRevenue;
    private int perviousMonthRevenue;
    private int totalRevenue;

    public Studio() {}
    public Studio(String shortName, String longName){
        this.shortName = shortName;
        this.longName = longName;
        this.currentMonthRevenue = 0;
        this.perviousMonthRevenue = 0;
        this.totalRevenue = 0;
    }

    public Long getId() {
        return this.id;
    }

    public String getShortName(){
        return this.shortName;
    }

    public String getLongName(){
        return this.longName;
    }

    public int getCurrentMonthRevenue(){
        return this.currentMonthRevenue;
    }

    public void setCurrentMonthRevenue(int increase){
        this.currentMonthRevenue += increase;
    }

    public int getPreviousMonthRevenue(){
        return this.perviousMonthRevenue;
    }

    public int getTotalRevenue(){
        return this.totalRevenue;
    }

    public void nextMonth() {
        this.perviousMonthRevenue = this.currentMonthRevenue;
        this.totalRevenue += this.currentMonthRevenue;
        this.currentMonthRevenue = 0;
    }

    @Override
    public String toString() {
        return "{" +
                "'studioShortName':'" + getShortName() + "'" +
                ", 'studioLongName':'" + getLongName() + "'" +
                ", 'currentMonthRevenue':'" + getCurrentMonthRevenue() + "'" +
                ", 'previousMonthRevenue':'" + getPreviousMonthRevenue() + "'" +
                ", 'totalRevenue':'" + getTotalRevenue() + "'"+
                "}";

    }
}