package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.ClinicData;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.ClinicDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicDataService {
    private final ClinicDataRepository ClinicDataRepository;
    public ClinicDataService(ClinicDataRepository ClinicDataRepository) {
        this.ClinicDataRepository = ClinicDataRepository;
    }
    public List<ClinicData> getClinicData() {
        return ClinicDataRepository.findAll();
    }

    public ClinicData saveClinicData(ClinicData newClinicData) {
        return ClinicDataRepository.save(newClinicData);
    }

    public ClinicData getClinicByclinicId(Long clinicId) {
        Optional<ClinicData> clinic = ClinicDataRepository.findById(clinicId);
        return clinic.get();
    }

    public ClinicData updateClinicByclinicId(Long clinicId, ClinicData updatedClinic) {
        Optional<ClinicData> clinic = ClinicDataRepository.findById(clinicId);
        ClinicData oldClinic = clinic.get();
        updateClinic(oldClinic, updatedClinic);
        return ClinicDataRepository.save(oldClinic);
    }

    private void updateClinic(ClinicData oldClinic, ClinicData updatedClinic) {
        oldClinic.setAddress(updatedClinic.getAddress());
        oldClinic.setCity(updatedClinic.getCity());
    }

    public String deleteClinicByclinicId(Long clinicId) {
        ClinicDataRepository.deleteById(clinicId);
        return "Mentioned clinic was deleted!";
    }
}
