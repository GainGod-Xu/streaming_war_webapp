package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;


@Entity
@Table(name= "archives")
public class Archive {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int month;
    private int year;
    private ArrayList<String> groupArchive;
    private ArrayList<String> streamArchive;
    private ArrayList<String> studioArchive;

    public Archive(int month, int year) {
        this.month = month;
        this.year = year;
        this.groupArchive = new ArrayList<String>();
        this.streamArchive = new ArrayList<String>();
        this.studioArchive = new ArrayList<String>();
    }

    public Archive() {}

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getGroupArchive() {
        return groupArchive;
    }

    public ArrayList<String> getStreamArchive() {
        return streamArchive;
    }

    public ArrayList<String> getStudioArchive() {
        return studioArchive;
    }

    public void setGroupArchive(ArrayList<String> groupArchive){
        this.groupArchive = groupArchive;
    }

    public void setStreamArchive(ArrayList<String> streamArchive) {
        this.streamArchive = streamArchive;
    }

    public void setStudioArchive(ArrayList<String> studioArchive) {
        this.studioArchive = studioArchive;
    }

    @Override
    public String toString() {
        return  "{" +
                "month='" + getMonth() + "'" +
                ", year='" + getYear() + "'" +
                ", groupArchive" + getGroupArchive() + "'" +
                ", streamArchive" + getStreamArchive() + "'" +
                ", studioArchive" + getStudioArchive() + "'" +
                "}";
    }
}
