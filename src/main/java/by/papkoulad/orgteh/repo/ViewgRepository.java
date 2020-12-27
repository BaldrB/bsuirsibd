package by.papkoulad.orgteh.repo;

import by.papkoulad.orgteh.models.Viewg;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ViewgRepository extends CrudRepository<Viewg, Integer> {

    List<Viewg> findByViewg(String viewg);
}
