package by.papkoulad.orgteh.repo;

import by.papkoulad.orgteh.models.TechAttribut;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TechAttributRepository extends CrudRepository<TechAttribut, Integer> {

    // List<TechAttribut> findByViewg(String TechAttribut);

}
