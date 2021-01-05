package by.papkoulad.orgteh.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.papkoulad.orgteh.models.NameTech;

@Repository
public interface NameTechRepository extends CrudRepository<NameTech, Integer> {
    
}
