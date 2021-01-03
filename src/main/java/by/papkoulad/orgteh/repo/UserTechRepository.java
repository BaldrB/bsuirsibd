package by.papkoulad.orgteh.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.papkoulad.orgteh.models.UserTech;


@Repository
public interface UserTechRepository extends CrudRepository<UserTech, Integer>{
    
}
