package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepo extends CrudRepository<Demo, Integer> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable
    @Override
    List<Demo> findAll();
}
