package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable
    @Override
    List<Subscription> findAll();
}
