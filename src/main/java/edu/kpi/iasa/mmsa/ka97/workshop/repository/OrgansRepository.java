package edu.kpi.iasa.mmsa.ka97.workshop.repository;

import edu.kpi.iasa.mmsa.ka97.workshop.model.Organs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrgansRepository extends JpaRepository<Organs, Long> {
    Optional<Organs> findById(Long organId);
}
