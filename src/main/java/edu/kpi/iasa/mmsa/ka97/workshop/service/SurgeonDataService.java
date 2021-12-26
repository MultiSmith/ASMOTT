package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.SurgeonData;
import edu.kpi.iasa.mmsa.ka97.workshop.model.SurgeonData;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.SurgeonDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeonDataService {
    private final SurgeonDataRepository SurgeonDataRepository;
    public SurgeonDataService(SurgeonDataRepository SurgeonDataRepository) {
        this.SurgeonDataRepository = SurgeonDataRepository;
    }
    public List<SurgeonData> getSurgeonData() {
        return SurgeonDataRepository.findAll();
    }

    public SurgeonData saveSurgeonData(SurgeonData newSurgeonData) {
        return SurgeonDataRepository.save(newSurgeonData);
    }

    public SurgeonData getSurgeonBysurgeonId(Long surgeonId) {
        Optional<SurgeonData> surgeon = SurgeonDataRepository.findById(surgeonId);
        return surgeon.get();
    }

    public SurgeonData updateSurgeonBysurgeonId(Long surgeonId, SurgeonData updatedSurgeon) {
        Optional<SurgeonData> surgeon = SurgeonDataRepository.findById(surgeonId);
        SurgeonData oldSurgeon = surgeon.get();
        updateSurgeon(oldSurgeon, updatedSurgeon);
        return SurgeonDataRepository.save(oldSurgeon);
    }

    private void updateSurgeon(SurgeonData oldSurgeon, SurgeonData updatedSurgeon) {
        oldSurgeon.setClinicId(updatedSurgeon.getClinicId());
        oldSurgeon.setSurname(updatedSurgeon.getSurname());
        oldSurgeon.setName(updatedSurgeon.getName());
        oldSurgeon.setFathersname(updatedSurgeon.getFathersname());
        oldSurgeon.setId_code(updatedSurgeon.getId_code());
    }

    public String deleteSurgeonBysurgeonId(Long surgeonId) {
        SurgeonDataRepository.deleteById(surgeonId);
        return "Mentioned surgeon was deleted!";
    }
}
