package edu.gatech.streamingwars;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
//import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
@RestController
@CrossOrigin
public class StreamingwarsApplication {

    // NOTE: autowired is a special annotation provided by the spring framework 
    // for enable dependency injection
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DemoRepo demoRepo;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private StreamRepo streamRepo;
    @Autowired
    private ArchiveRepo archiveRepo;
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    private int monthTimeStamp = 4;
    private int yearTimeStamp = 2021;


    public static void main(String[] args) { SpringApplication.run(StreamingwarsApplication.class, args); }

    
	@PostMapping("/time")
    public Map<String, String> ShowTime() {
        Map<String, String> map = new HashMap<>();
        map.put("Month", String.valueOf(monthTimeStamp));
        map.put("Year", String.valueOf(yearTimeStamp));
        return map;
    }
    
    
    @PostMapping("/nextMonth")
    public Map<String, String> NextMonth() {
        Map<String, String> map = new HashMap<>();
        monthTimeStamp += 1;
        if (monthTimeStamp > 12) {
            yearTimeStamp += 1;
            monthTimeStamp -= 12;
        }
        // clear
        List<Demo> demos = demoRepo.findAll();
        List<Stream> streams = streamRepo.findAll();
        List<Studio> studios = studioRepository.findAll();
        for (Demo demo: demos) {
            demo.nextMonth();
            demoRepo.save(demo);
        }
        for (Stream stream: streams) {
            stream.nextMonth();
            streamRepo.save(stream);
        }
        for (Studio studio: studios) {
            studio.nextMonth();
            studioRepository.save(studio);
        }
        offerRepository.deleteAll();
        subscriptionRepo.deleteAll();
        map.put("Month", String.valueOf(monthTimeStamp));
        map.put("Year", String.valueOf(yearTimeStamp));
        map.put("Response", "Updated to Next Month");

        return map;
    }


	@PostMapping("/register")
    public Map<String, String> UserRegister(@RequestBody User newUser)
    {
        Map<String, String> map = new HashMap<>();
        List<User> users = userRepo.findAll();
        for (User user: users) {
            if (user.getEmail().equals(newUser.getEmail())) {
                map.put("Response", "User Already Exists");
                return map;
            }
        }
        userRepo.save(newUser);
        map.put("Response", "Register Successful");
        return map;
    }

    
    @PostMapping("/login")
    public Map<String, String> UserLogin(@RequestBody User logUser)
    {
        Map<String, String> map = new HashMap<>();

        List<User> users = userRepo.findAll();
        for (User user: users) {
            if (user.getEmail().equals(logUser.getEmail())) {
                if (user.getPassword().equals(logUser.getPassword())) {
                    map.put("Response", "Login Successful");
                    map.put("Admin", String.valueOf(user.getAdmin()));
                    return map;
                }
                else {
                    map.put("Response", "Wrong Password");
                    return map;
                }
            }
        }
        map.put("Response", "User Not Exists");
        return map;
    }


    @PostMapping("/createGroup")
    public Map<String, String> GroupCreation(@RequestBody Demo newDemo)
    {
        Map<String, String> map = new HashMap<>();
        List<Demo> demos = demoRepo.findAll();
        for (Demo demo: demos) {
            if (demo.getDemoShortName().equals(newDemo.getDemoShortName())) {
                map.put("Response", "Demo Already Exists");
                return map;
            }
        }
        demoRepo.save(newDemo);
        map.put("shortname", newDemo.getDemoShortName());
        map.put("longname", newDemo.getDemoLongName());
        map.put("accounts", String.valueOf(newDemo.getDemoAccounts()));
        map.put("Response", "Group Creation Successful");
        return map;
    }


    @PostMapping("/updateGroup")
    public Map<String, String> GroupUpdate(@RequestBody Demo updateDemo)
    {
        Map<String, String> map = new HashMap<>();
        List<Demo> demos = demoRepo.findAll();
        for (Demo demo: demos) {
            if (demo.getDemoShortName().equals(updateDemo.getDemoShortName())) {
                demo.setDemoLongName(updateDemo.getDemoLongName());
                demo.setDemoAccounts(updateDemo.getDemoAccounts());
                demoRepo.save(demo);
                map.put("shortname", demo.getDemoShortName());
                map.put("longname", demo.getDemoLongName());
                map.put("accounts", String.valueOf(demo.getDemoAccounts()));
                map.put("Response", "Demo Update Successful");
                return map;
            }
        }
        map.put("Response", "Group Not Exists");
        return map;
    }

    @PostMapping("/displayGroup")
    public Map<String, String> GroupDisplay(@RequestBody Object requestBody)
    {
        Map<String, String> map = new HashMap<>();
        String demoName = ((Map) requestBody).get("demoShortName").toString();
        List<Demo> demos = demoRepo.findAll();
        for (Demo demo: demos) {
            if (demo.getDemoShortName().equals(demoName)) {
                map.put("ShortName", demo.getDemoShortName());
                map.put("LongName", demo.getDemoLongName());
                map.put("Size", String.valueOf(demo.getDemoAccounts()));
                map.put("Current_period", String.valueOf(demo.getDemoCurrentSpending()));
                map.put("Previous_period",String.valueOf(demo.getDemoPreviousSpending()));
                map.put("Total",String.valueOf(demo.getDemoTotalSpending()));
                return map;
            }
        }
        map.put("Response", "Group Not Exists");
        return map;
    }


    @PostMapping("/watchEvent")
    public Map<String, String> GroupWatchEvent(@RequestBody Object requestBody)
    {
        Map<String, String> map = new HashMap<>();
        String demoName = ((Map) requestBody).get("demoShortName").toString();
        int percent = Integer.parseInt((String)((Map) requestBody).get("percentage"));
        String streamName = ((Map) requestBody).get("streamName").toString();
        String eventName = ((Map) requestBody).get("eventName").toString();
        int year = Integer.parseInt((String) ((Map) requestBody).get("year"));
        String currentEvent = eventName + "_" + String.valueOf(year);

        int ppvPrice=0;
        int subPrice=0;
        int watchViewerCount=0;
        int newViewerCount = 0;
        int watchCost=0;
        String watchType = "";
        //get event type
        List<Offer> offers = offerRepository.findAll();
        boolean checkOfferExists = false;
        for (Offer offer: offers) {
            if ((offer.getName().equals(eventName))&&(offer.getYear() == year)) {
                watchType = offer.getType();
                if (watchType.equals("ppv")) {
                    ppvPrice = offer.getViewingPrice();
                }
                checkOfferExists = true;
            }
        }
        if (!checkOfferExists) {
            map.put("Response", "Offer Not Exists");
            return map;
        }

       //get stream subscription fee
        List<Stream> streams = streamRepo.findAll();
        boolean checkStreamExists = false;
        for (Stream stream: streams) {
            if (stream.getShortName().equals(streamName)) {
                subPrice = stream.getSubscriptionFee();
                checkStreamExists = true;
            }
        }
        if (!checkStreamExists) {
            map.put("Response", "Stream Not Exists");
            return map;
        }

        // check demogroup exists and update spendings
        List<Demo> demos = demoRepo.findAll();
        boolean checkDemoExists = false;
        for (Demo demo: demos) {
            if (demo.getDemoShortName().equals(demoName)) {
                if (watchType.equals("ppv")) {
                    watchViewerCount = (demo.getDemoAccounts())* percent/100;
                    watchCost = watchViewerCount * ppvPrice;
                    demo.addSpending(watchCost);
                    demo.watchEvent(currentEvent);
                    demoRepo.save(demo);
                }
                if (watchType.equals("movie")) {
                    watchViewerCount = demo.getDemoAccounts() * percent/100;
                    List<Subscription> subscriptions = subscriptionRepo.findAll();
                    boolean checkSubExists = false;
                    for (Subscription subscription: subscriptions) {
                        if ((subscription.getDemoName().equals(demoName)) && (subscription.getStreamName().equals(streamName))) {
                            checkSubExists = true;
                            if (watchViewerCount <= subscription.getViewerCount()) { newViewerCount = 0; }
                            if (watchViewerCount > subscription.getViewerCount())
                            {
                                newViewerCount = watchViewerCount - subscription.getViewerCount();
                                subscription.setViewerCount(watchViewerCount);
                                subscriptionRepo.save(subscription);
                            }
                        }
                    }
                    if (!checkSubExists) {
                        Subscription subscription = new Subscription(demoName, streamName);
                        subscription.setViewerCount(watchViewerCount);
                        subscriptionRepo.save(subscription);
                        newViewerCount = watchViewerCount;
                    }
                    watchCost = newViewerCount * subPrice;
                    demo.addSpending(watchCost);
                    demo.watchEvent(currentEvent);
                    demoRepo.save(demo);
                }
                checkDemoExists = true;
//                map.put("Response1", "Demo Spending Updated");
            }
        }
        if (!checkDemoExists) {
            map.put("Response", "Group Not Exists");
            return map;
        }

        // update revenue for stream
        for (Stream stream: streams) {
            if (stream.getShortName().equals(streamName)) {
                stream.addRevenue(watchCost);
                streamRepo.save(stream);
                map.put("Response", "Demo Spending and Stream Revenue Updated");
            }
        }
        return map;
    }


    @PostMapping("/createStudio")
    public Map<String, String> createStudio(@RequestBody Studio newStudio) {
        List<Studio> studioList = studioRepository.findAll();
        Map<String, String> map = new HashMap<>();
        for (Studio studio: studioList){
            if (studio.getShortName().equals(newStudio.getShortName())){
                map.put("Response", "Studio " + newStudio.getShortName() + " Already Exists!");
                return map;
            }
        }
        studioRepository.save(newStudio);
        map.put("Response", newStudio.getShortName() + " Is Created!");
        return map;
    }


    @PostMapping("/displayStudio")
    public Map<String, String> displayStudio(@RequestBody Object requestBody) {
        List<Studio> studioList = studioRepository.findAll();
        String studioShortName = ((Map) requestBody).get("shortName").toString();
        Map<String, String> map = new HashMap<>();
        for (Studio studio: studioList){
            if (studio.getShortName().equals(studioShortName)){
                map.put("shortName", studio.getShortName());
                map.put("longName", studio.getLongName());
                map.put("currentMonthRevenue", String.valueOf(studio.getCurrentMonthRevenue()));
                map.put("previousMonthRevenue", String.valueOf(studio.getPreviousMonthRevenue()));
                map.put("totalRevenue", String.valueOf(studio.getTotalRevenue()));
                return map;
            }
        }
        map.put("Response", "Studio Doesn't Exist!");
        return map;
    }


    @PostMapping("/createEvent")
    public Map<String, String> createEvent(@RequestBody Event newEvent)
    {
        Map<String, String> map = new HashMap<>();
        List<Event> events = eventRepo.findAll();
        List<Studio> studios = studioRepository.findAll();
        for (Event event: events) {
            if (event.getName().equals(newEvent.getName()) && event.getYear() == newEvent.getYear()) {
                map.put("Response", "Event already exists");
                return map;
            }
        }
        for (Studio studio: studios) {
            if(newEvent.getStudioShortName().equals(studio.getShortName())) {
                eventRepo.save(newEvent);
                map.put("Response", "Event has been created Successfully");
                return map;
            }
        }
        map.put("Response", "Studio Not Exists");
        return map;
    }


    //display all events
    @PostMapping("/displayEvents")
    public List<Map<String,String>> displayAllEvent() {
        List<Event> events = eventRepo.findAll();
        List<Map<String,String>> allEvents = new ArrayList();
        for (Event event: events) {
            HashMap<String,String> map = new HashMap<> ();
            map.put("eventType", event.getEventType());
            map.put("name", event.getName());
            map.put("year", String.valueOf(event.getYear()));
            map.put("duration", String.valueOf(event.getDuration()));
            map.put("studioShortName", event.getStudioShortName());
            map.put("eventLicensingFee", String.valueOf(event.getEventLicensingFee()));
            allEvents.add(map);
        }
        return allEvents;
    }


    @PostMapping("/updateEvent")
    public Map<String, String> updateEvent(@RequestBody Event updateEvent)
    {
        Map<String, String> map = new HashMap<>();
        List<Event> events = eventRepo.findAll();
        for (Event event: events) {
            if (event.getName().equals(updateEvent.getName()) && event.getYear() == updateEvent.getYear()) {
                // check event is already accessed
//                List<Demo> demos = demoRepo.findAll();
//                for (Demo demo: demos) {
//                    if (demo.checkWatchHistory(event.getName(), event.getYear())) {
//                        if (event.getEventLicensingFee() != updateEvent.getEventLicensingFee()) {
//                            map.put("Response", "Event license fee cannot be changed");
//                            return map;
//                        }
//                    }
//                }
                event.setEventLicensingFee(updateEvent.getEventLicensingFee());
                event.setDuration(updateEvent.getDuration());
                eventRepo.save(event);
                map.put("Response", "Event has been updated Successfully");
                return map;
            }
        }
        map.put("Response", "Event Not Exists");
        return map;
    }


    @PostMapping("/createOffer")
    public Map<String, String> createOffer(@RequestBody Offer newOffer) {
        Map<String, String> map = new HashMap<>();
        List<Offer> offerList = offerRepository.findAll();
        for (Offer offer: offerList){
            if (offer.getName().equals(newOffer.getName()) && offer.getYear() == newOffer.getYear() && offer.getType().equals(newOffer.getType())){
                map.put("Response", "Offer " + newOffer.getName() + " Already Exists!");
                return map;
            }

        }
        List<Stream> streamList = streamRepo.findAll();
        List<Studio> studioList = studioRepository.findAll();
        List<Event> eventList = eventRepo.findAll();
        for (Stream stream: streamList) {
            if (stream.getShortName().equals(newOffer.getService())) {
                for (Event event: eventList){
                    if (event.getName().equals(newOffer.getName()) && event.getYear() == newOffer.getYear() && event.getEventType().equals(newOffer.getType())) {
                        offerRepository.save(newOffer);
                        //Handle Stream Licensingfee
                        stream.setTotalLicensingFee(event.getEventLicensingFee());
                        //Handle Studio Licensingfee
                        streamRepo.save(stream);
                        for (Studio studio: studioList){
                            if (studio.getShortName().equals(event.getStudioShortName())){
                                studio.setCurrentMonthRevenue(event.getEventLicensingFee());
                                studioRepository.save(studio);
                            }
                        }
                        map.put("Response", newOffer.getName() + " Is Created!");
                        return map;
                    }
                }
            }
        }
        map.put("Response", "The Event or StreamingService Doesn't Exist!");
        return map;
    }


//    @PostMapping("/displayOffers")
//    public List<Map<String, String>> displayOffers() {
//        List<Offer> offerList = offerRepository.findAll();
//        List<Map<String, String>> response = new ArrayList();
//        for (Offer offer: offerList){
//            Map<String, String> map = new HashMap<>();
//            map.put("Service", offer.getService());
//            map.put("Type", offer.getType());
//            map.put("Name", offer.getName());
//            map.put("Year", String.valueOf(offer.getYear()));
//            response.add(map);
//        }
//        return response;
//    }
    @PostMapping("/displayOffers")
    public List<Map<String, String>> displayOffers() {
        List<Offer> offerList = offerRepository.findAll();
        List<Map<String, String>> response = new ArrayList();
        for (Offer offer: offerList){
            Map<String, String> map = new HashMap<>();
            map.put("Service", offer.getService());
            map.put("Type", offer.getType());
            map.put("Name", offer.getName());
            map.put("Year", String.valueOf(offer.getYear()));
            if (offer.getType().equals("ppv")){
                map.put("ViewingPrice", String.valueOf(offer.getViewingPrice()));
            }
            response.add(map);
        }
        return response;
    }


    @PostMapping("/retractOffer")
    public Map<String, String> retractOffer(@RequestBody Object requestBody) {
        List<Offer> offerList = offerRepository.findAll();
        Map<String, String> response = new HashMap<>();
        String service = ((Map) requestBody).get("Service").toString();
        String type = "movie";
        String name = ((Map) requestBody).get("Name").toString();
        int year = Integer.valueOf(((Map) requestBody).get("Year").toString());

        for (Offer offer: offerList){
            if (offer.getService().equals(service) && offer.getType().equals(type) && offer.getName().equals(name) && offer.getYear() == year){
                offerRepository.delete(offer);
                response.put("Response", "Movie " + name + " Is Retracted From " + service + "!" );
                return response;
            }
        }
        response.put("Response", "Movie " + name + " Is not Offered by " + service + "!");
        return response;
    }


    //Create stream
    @PostMapping("/createStream")
    public Map<String, String> createStream(@RequestBody Stream newStream)
    {
        Map<String, String> map = new HashMap<>();
        List<Stream> streams = streamRepo.findAll();
        for (Stream stream: streams) {
            if (stream.getShortName().equals(newStream.getShortName())) {
                map.put("Response", "Stream already exists.");
                return map;
            }
        }
        streamRepo.save(newStream);
        map.put("Response", "Stream has been created Successfully.");
        return map;

    }

    //display stream
    @PostMapping("/displayStream")
    public Map<String, String> displayStream(@RequestBody Object requestBody) {
        List<Stream> streams = streamRepo.findAll();
        String shortName= ((Map) requestBody).get("shortName").toString();
        Map<String, String> map = new HashMap<>();
        for (Stream stream: streams){
            if (stream.getShortName().equals(shortName)){
                map.put("ShortName", stream.getShortName());
                map.put("LongName", stream.getLongName());
                map.put("SubscriptionFee", String.valueOf(stream.getSubscriptionFee()));
                map.put("CurrentMonthRevenue", String.valueOf(stream.getCurrentMonthRevenue()));
                map.put("PreviousMonthRevenue", String.valueOf(stream.getPreviousMonthRevenue()));
                map.put("TotalRevenue", String.valueOf(stream.getTotalRevenue()));
                map.put("TotalLicensingFee", String.valueOf(stream.getTotalLicensingFee()));
                return map;
            }
        }
        map.put("Response", "Stream doesn't exist!");
        return map;
    }


    //update stream
    @PostMapping("/updateStream")
    public Map<String, String> updateStream(@RequestBody Stream updateStream)
    {
        Map<String, String> map = new HashMap<>();
        List<Stream> streams = streamRepo.findAll();
        for (Stream stream: streams) {
            if (stream.getShortName().equals(updateStream.getShortName())) {
                stream.setSubscriptionFee(updateStream.getSubscriptionFee());
                stream.setLongName(updateStream.getLongName());
                streamRepo.save(stream);
                map.put("Response", "Stream has been updated Successfully.");
                return map;
            }
        }
        map.put("Response", "Stream short name cannot be changed or stream does not exist.");
        return map;
    }

    @PostMapping("/archive")
    public Map<String, String> createArchive()
    {
        Map<String, String> map = new HashMap<>();
        int month = monthTimeStamp;
        int year = yearTimeStamp;

        List<Stream> streams = streamRepo.findAll();
        List<Demo> demos = demoRepo.findAll();
        List<Studio> studios = studioRepository.findAll();

        ArrayList<String> demoString = new ArrayList<String> ();
        ArrayList<String> streamString = new ArrayList<String> ();
        ArrayList<String> studioString = new ArrayList<String> ();
        for (Demo demo: demos) {
            demoString.add(demo.toString());
        }
        for (Stream stream: streams) {
            streamString.add(stream.toString());
        }
        for (Studio studio: studios) {
            studioString.add(studio.toString());
        }

        List<Archive> archives = archiveRepo.findAll();
        for (Archive archive: archives) {
                if((archive.getYear() == year) && (archive.getMonth() == month)) {
                    archive.setGroupArchive(demoString);
                    archive.setStreamArchive(streamString);
                    archive.setStudioArchive(studioString);
                    archiveRepo.save(archive);
                    map.put("Response", "Archive Updated Successfully");
                    return map;
                }
        }

        Archive archive = new Archive(month, year);
        archive.setGroupArchive(demoString);
        archive.setStreamArchive(streamString);
        archive.setStudioArchive(studioString);
        archiveRepo.save(archive);
        map.put("Response", "Archived Successfully");
        return map;
    }

    @PostMapping("/archiveDisplay")
    public Map<String, ArrayList<String>> archiveDisplay(@RequestBody Object requestBody) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        int month = Integer.parseInt((String)((Map) requestBody).get("month"));
        int year = Integer.parseInt((String)((Map) requestBody).get("year"));
        List<Archive> archives = archiveRepo.findAll();
        for (Archive archive: archives) {
            if((archive.getYear() == year) && (archive.getMonth() == month)) {
                ArrayList<String> month_year = new ArrayList<String> ();
                month_year.add(String.valueOf(month));
                month_year.add(String.valueOf(year));
                map.put("month_year", month_year);
                map.put("groupArchive", archive.getGroupArchive());
                map.put("streamArchive", archive.getStreamArchive());
                map.put("studioArchive", archive.getStudioArchive());
                return map;
            }
        }
//        map.put("Response", "Archive Not Exists");
        return map;
    }

}
