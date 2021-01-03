package by.papkoulad.orgteh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.papkoulad.orgteh.models.Grouptech;

@Repository
public interface GrouptechRepository extends JpaRepository<Grouptech, Long>{
    Grouptech findByNameIgnoreCase(String name);
    
}
