package by.papkoulad.orgteh.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.papkoulad.orgteh.models.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    
}
