package by.papkoulad.orgteh.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.papkoulad.orgteh.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{
    
}
