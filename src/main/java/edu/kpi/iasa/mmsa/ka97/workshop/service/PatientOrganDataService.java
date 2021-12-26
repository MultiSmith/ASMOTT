package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.PatientOrganData;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.PatientOrganDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientOrganDataService {
    private final PatientOrganDataRepository PatientOrganDataRepository;
    public PatientOrganDataService(PatientOrganDataRepository PatientOrganDataRepository) {
        this.PatientOrganDataRepository = PatientOrganDataRepository;
    }
    public List<PatientOrganData> getPatientOrganData() {
        return PatientOrganDataRepository.findAll();
    }

    public PatientOrganData savePatientOrganData(PatientOrganData newPatientOrganData) {
        return PatientOrganDataRepository.save(newPatientOrganData);
    }

    public PatientOrganData getPatientBypatientId(Long patientId) {
        Optional<PatientOrganData> patient = PatientOrganDataRepository.findById(patientId);
        return patient.get();
    }

    public PatientOrganData updatePatientBypatientId(Long patientId, PatientOrganData updatedPatient) {
        Optional<PatientOrganData> patient = PatientOrganDataRepository.findById(patientId);
        PatientOrganData oldPatient = patient.get();
        updatePatient(oldPatient, updatedPatient);
        return PatientOrganDataRepository.save(oldPatient);
    }

    private void updatePatient(PatientOrganData oldPatient, PatientOrganData updatedPatient) {
        oldPatient.setSurname(updatedPatient.getSurname());
        oldPatient.setName(updatedPatient.getName());
        oldPatient.setFathersname(updatedPatient.getFathersname());
        oldPatient.setOrgan_type(updatedPatient.getOrgan_type());
        oldPatient.setClinic_id(updatedPatient.getClinic_id());
        oldPatient.setBlood_type(updatedPatient.getBlood_type());
        oldPatient.setResus_factor(updatedPatient.getResus_factor());
        oldPatient.setDate(updatedPatient.getDate());
        oldPatient.setId_code(updatedPatient.getId_code());
        oldPatient.setDonor_or_recip(updatedPatient.getDonor_or_recip());
        oldPatient.setStatus(updatedPatient.getStatus());
    }

    public String deletePatientBypatientId(Long patientId) {
        PatientOrganDataRepository.deleteById(patientId);
        return "Mentioned patient was deleted!";
    }
}
