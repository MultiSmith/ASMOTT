package edu.kpi.iasa.mmsa.ka97.workshop.repository;

import edu.kpi.iasa.mmsa.ka97.workshop.model.PatientOrganData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientOrganDataRepository extends JpaRepository<PatientOrganData, Long> {
    Optional<PatientOrganData> findById(Long patientId);
}
