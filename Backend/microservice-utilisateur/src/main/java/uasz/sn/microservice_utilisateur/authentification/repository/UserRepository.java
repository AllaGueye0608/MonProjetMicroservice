package uasz.sn.microservice_utilisateur.authentification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.sn.microservice_utilisateur.authentification.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}
