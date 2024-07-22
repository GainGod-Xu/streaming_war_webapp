package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable

    @Override
    List<Event> findAll();
}