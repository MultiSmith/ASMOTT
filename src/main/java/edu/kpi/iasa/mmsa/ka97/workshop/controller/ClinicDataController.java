package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.ClinicData;
import edu.kpi.iasa.mmsa.ka97.workshop.model.ClinicData;
import edu.kpi.iasa.mmsa.ka97.workshop.service.ClinicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/clinic_data")
public class ClinicDataController {

    private final ClinicDataService ClinicDataService;

    @Autowired
    public ClinicDataController(ClinicDataService ClinicDataService) {
        this.ClinicDataService = ClinicDataService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<ClinicData>> getClinicData() {
        return ResponseEntity.ok(ClinicDataService.getClinicData());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ClinicData> postClinicData(@Valid @RequestBody ClinicData newClinicData) {
        return ResponseEntity.ok(ClinicDataService.saveClinicData(newClinicData));
    }

    @GetMapping(value = "/getById/{clinicId}")
    public ResponseEntity<ClinicData> getClinic(@PathVariable Long clinicId) {
        return ResponseEntity.ok(ClinicDataService.getClinicByclinicId(clinicId));
    }

    @PutMapping(value = "/update/{clinicId}")
    public ResponseEntity<ClinicData> updateClinic(@PathVariable Long clinicId, @Valid @RequestBody ClinicData updatedClinic) {
        return ResponseEntity.ok(ClinicDataService.updateClinicByclinicId(clinicId, updatedClinic));
    }

    @DeleteMapping(value = "/delete/{clinicId}")
    public ResponseEntity<String> deleteClinic(@PathVariable Long clinicId) {
        return ResponseEntity.ok(ClinicDataService.deleteClinicByclinicId(clinicId));
    }

}