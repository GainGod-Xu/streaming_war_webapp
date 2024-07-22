package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name= "streams")
public class Stream {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String shortName;
    private String longName;
    private int subscriptionFee;
    private int currentMonthRevenue;
    private int previousMonthRevenue;
    private int totalRevenue;
    private int totalLicensingFee;

    public Stream() {}

    //Constructor
    public Stream(String shortName, String longName, int subscriptionFee) {
        this.shortName = shortName;
        this.longName = longName;
        this.subscriptionFee = subscriptionFee;
        this.currentMonthRevenue = 0;
        this.previousMonthRevenue = 0;
        this.totalRevenue = 0;
        this.totalLicensingFee = 0;

    }

    //Getter
    public int getId() { return id; }
    public String getShortName() { return shortName; }
    public String getLongName() { return longName; }
    public int getSubscriptionFee() { return subscriptionFee; }
    public int getCurrentMonthRevenue() { return this.currentMonthRevenue; }
    public int getPreviousMonthRevenue() { return this.previousMonthRevenue; }
    public int getTotalRevenue() {return this.totalRevenue; }
    public int getTotalLicensingFee() {return this.totalLicensingFee; }


    //Setter
    public void setId(int id) { this.id = id; }
    public void setShortName(String shortName) { this.shortName = shortName; }
    public void setLongName(String longName) { this.longName = longName; }
    public void setSubscriptionFee(int subscriptionFee) { this.subscriptionFee = subscriptionFee; }

    public void addRevenue(int viewingCost) {currentMonthRevenue += viewingCost;}
    public void setTotalLicensingFee(int increase){ this.totalLicensingFee += increase; }

    public void nextMonth() {
        totalRevenue += currentMonthRevenue;
        previousMonthRevenue = currentMonthRevenue;
        currentMonthRevenue = 0;
    }


    @Override
    public String toString() {
        return  "{" +
                "'streamShortName':'" + getShortName() + "'" +
                ", 'streamLongName':'" + getLongName() + "'" +
                ", 'subscriptionFee':'" + getSubscriptionFee() + "'"+
                ", 'currentMonthRevenue':'" + getCurrentMonthRevenue() + "'" +
                ", 'previousMonthRevenue':'" + getPreviousMonthRevenue() + "'" +
                ", 'totalRevenue':'" + getTotalRevenue() + "'"+
                ", 'totalLicensingFee':'" + getTotalLicensingFee() + "'"+
                "}";
    }
}
