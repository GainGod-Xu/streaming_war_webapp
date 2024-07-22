package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StudioRepository extends CrudRepository<Studio, Long> {
    Studio findById(long id);
    @Override
    List<Studio> findAll();
}
