package edu.kpi.iasa.mmsa.ka97.workshop.repository;

import edu.kpi.iasa.mmsa.ka97.workshop.model.SurgeonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SurgeonDataRepository extends JpaRepository<SurgeonData, Long> {
    //List<SurgeonData> findAllByclinicId(Long clinicId);
}
