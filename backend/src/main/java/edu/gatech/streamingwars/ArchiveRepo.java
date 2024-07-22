package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArchiveRepo extends CrudRepository<Archive, Integer> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable
//    List<User> findByEmail(String email);
//    void deleteByEmail(String email);
    @Override
    List<Archive> findAll();
}
