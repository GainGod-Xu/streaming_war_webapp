package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name= "events")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String eventType;
    private String name;
    private int year;
    private int duration;
    private String studioShortName;
    private int eventLicensingFee;

    public Event() {}

    //Constructor
    public Event(String eventType, String name, int year, int duration, String studioShortName,
                 int eventLicensingFee) {
        this.eventType = eventType;
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.studioShortName = studioShortName;
        this.eventLicensingFee = eventLicensingFee;
    }

    //Getter
    public int getId() { return id; }
    public String getEventType() { return eventType; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public int getDuration() { return duration; }
    public String getStudioShortName() { return studioShortName; }
    public int getEventLicensingFee() { return eventLicensingFee; }

    //Setter
    public void setId(int id) { this.id = id; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setName(String name) { this.name = name; }
    public void setYear(int year) { this.year = year; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setStudioShortName(String studioShortName) { this.studioShortName = studioShortName; }
    public void setEventLicensingFee(int eventLicensingFee) { this.eventLicensingFee = eventLicensingFee; }

    @Override
    public String toString() {
        return  "{" +
                "Event type='" + getEventType() + "'" +
                ", Event name='" + getName() + "'" +
                ", Year produced='" + getYear() + "'" +
                ", Duration='" + getDuration() + "'" +
                ", Studio='" + getStudioShortName() + "'" +
                ", Licensing fee='" + getEventLicensingFee() + "'" +
                "}";
    }
}