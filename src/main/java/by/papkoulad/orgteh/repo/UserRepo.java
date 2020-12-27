package by.papkoulad.orgteh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import by.papkoulad.orgteh.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
