package by.papkoulad.orgteh.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.papkoulad.orgteh.models.Grouptech;

@Repository
public interface GrouptechRepository extends CrudRepository<Grouptech, Integer>{
    
}
