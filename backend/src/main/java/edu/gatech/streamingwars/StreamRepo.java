package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StreamRepo extends CrudRepository<Stream, Integer> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable

    @Override
    List<Stream> findAll();
}
