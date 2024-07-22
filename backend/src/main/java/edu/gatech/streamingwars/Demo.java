package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Entity
@Table(name= "groups")
public class Demo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String demoShortName;
    private String demoLongName;
    private int demoAccounts;
    private int demoCurrentSpending;
    private int demoPreviousSpending;
    private int demoTotalSpending ;
    private String demoWatchHistory;


    public Demo( String shortName, String longName, int accounts ) {
        this.demoShortName = shortName;
        this.demoLongName = longName;
        this.demoAccounts = accounts;
        this.demoCurrentSpending = 0;
        this.demoPreviousSpending = 0;
        this.demoTotalSpending = 0;
        this.demoWatchHistory = "";
    }

    public Demo() {}
    public int getId() {
        return id;
    }
    public int getDemoAccounts() {
        return demoAccounts;
    }
    public int getDemoCurrentSpending() {
        return demoCurrentSpending;
    }
    public int getDemoPreviousSpending() {
        return demoPreviousSpending;
    }
    public int getDemoTotalSpending() {
        return demoTotalSpending;
    }
    public String getDemoLongName() {
        return demoLongName;
    }
    public String getDemoShortName() {
        return demoShortName;
    }
    public String getDemoWatchHistory() { return demoWatchHistory; }

    public void watchEvent(String eventName) {
        if (demoWatchHistory == "") {
            demoWatchHistory += eventName;
        }
        else {
            demoWatchHistory = demoWatchHistory + ";" + eventName;
        }
    }

    public boolean checkWatchHistory(String eventName, int eventYear) {
        String event = eventName + "_" +  String.valueOf(eventYear);
        ArrayList<String> watchHistory= new ArrayList<String>();
        boolean check = false;
        if (demoWatchHistory == "") {
            return check;
        }
        else {
            String[] strs = demoWatchHistory.split(";");
            for (String s:strs) {
                watchHistory.add(s);
            }
            if (watchHistory.contains(event)) {
                check = true;
            }
            return  check;
        }
    }

    public void nextMonth() {
        demoTotalSpending += demoCurrentSpending;
        demoPreviousSpending = demoCurrentSpending;
        demoCurrentSpending = 0;
        demoWatchHistory = "";
    }

    public void setDemoAccounts(int demoAccounts) {
        this.demoAccounts = demoAccounts;
    }
    public void setDemoCurrentSpending(int demoCurrentSpending) {
        this.demoCurrentSpending = demoCurrentSpending;
    }
    public void setDemoLongName(String demoLongName) {
        this.demoLongName = demoLongName;
    }
    public void setDemoPreviousSpending(int demoPreviousSpending) {
        this.demoPreviousSpending = demoPreviousSpending;
    }
    public void setDemoShortName(String demoShortName) {
        this.demoShortName = demoShortName;
    }
    public void setDemoTotalSpending(int demoTotalSpending) {
        this.demoTotalSpending = demoTotalSpending;
    }
    public void addSpending(int viewingCost) { demoCurrentSpending += viewingCost; }
    @Override
    public String toString() {
        return  "{" +
                "'demoShortName':'" + getDemoShortName() + "'" +
                ", 'demoLongName':'" + getDemoLongName() + "'" +
                ", 'demoAccounts':'" + getDemoAccounts() + "'" +
                ", 'demoCurrentSpending':'" + getDemoCurrentSpending() + "'" +
                ", 'demoPreviousSpending':'" + getDemoPreviousSpending() + "'"+
                ", 'demoTotalSpending':'" + getDemoTotalSpending() + "'"+
                "}";
    }


}
