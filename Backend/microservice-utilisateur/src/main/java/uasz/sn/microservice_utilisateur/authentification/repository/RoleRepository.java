package uasz.sn.microservice_utilisateur.authentification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uasz.sn.microservice_utilisateur.authentification.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findByRole(String role);
}
