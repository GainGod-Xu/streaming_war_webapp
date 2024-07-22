package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name= "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String demoName;
    private String streamName;
    private int viewerCount;

    public Subscription() {}
    public Subscription(String demoName, String streamName) {
        this.demoName = demoName;
        this.streamName = streamName;
        this.viewerCount = 0;
    }

    public void setViewerCount(int viewerCount) { this.viewerCount = viewerCount; }
    public String getDemoName() { return demoName; }
    public String getStreamName() { return streamName; }
    public int getViewerCount() { return viewerCount; }

}