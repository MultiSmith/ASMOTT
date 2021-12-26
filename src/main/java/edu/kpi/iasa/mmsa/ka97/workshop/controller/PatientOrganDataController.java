package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.PatientOrganData;
import edu.kpi.iasa.mmsa.ka97.workshop.service.PatientOrganDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/patient_organ_data")
public class PatientOrganDataController {

    private final PatientOrganDataService patientOrganDataService;

    @Autowired
    public PatientOrganDataController(PatientOrganDataService patientOrganDataService) {
        this.patientOrganDataService = patientOrganDataService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<PatientOrganData>> getPatients() {
        return ResponseEntity.ok(patientOrganDataService.getPatientOrganData());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<PatientOrganData> postPatientOrganData(@Valid @RequestBody PatientOrganData newPatientOrganData) {
        return ResponseEntity.ok(patientOrganDataService.savePatientOrganData(newPatientOrganData));
    }

    @GetMapping(value = "/getById/{patientId}")
    public ResponseEntity<PatientOrganData> getPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientOrganDataService.getPatientBypatientId(patientId));
    }

    @PutMapping(value = "/update/{patientId}")
    public ResponseEntity<PatientOrganData> updatePatient(@PathVariable Long patientId, @Valid @RequestBody PatientOrganData updatedPatient) {
        return ResponseEntity.ok(patientOrganDataService.updatePatientBypatientId(patientId, updatedPatient));
    }

    @DeleteMapping(value = "/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientOrganDataService.deletePatientBypatientId(patientId));
    }
}
