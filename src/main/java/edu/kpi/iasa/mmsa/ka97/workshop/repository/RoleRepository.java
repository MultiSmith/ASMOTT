package edu.kpi.iasa.mmsa.ka97.workshop.repository;

import edu.kpi.iasa.mmsa.ka97.workshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
