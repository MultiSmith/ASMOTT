package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.SurgeonData;
import edu.kpi.iasa.mmsa.ka97.workshop.model.SurgeonData;
import edu.kpi.iasa.mmsa.ka97.workshop.service.SurgeonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/surgeon_data")
public class SurgeonDataController {

    private final SurgeonDataService SurgeonDataService;

    @Autowired
    public SurgeonDataController(SurgeonDataService SurgeonDataService) {
        this.SurgeonDataService = SurgeonDataService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<SurgeonData>> getSurgeonData() {
        return ResponseEntity.ok(SurgeonDataService.getSurgeonData());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<SurgeonData> postSurgeonData(@Valid @RequestBody SurgeonData newSurgeonData) {
        return ResponseEntity.ok(SurgeonDataService.saveSurgeonData(newSurgeonData));
    }

    @GetMapping(value = "/getById/{surgeonId}")
    public ResponseEntity<SurgeonData> getSurgeon(@PathVariable Long surgeonId) {
        return ResponseEntity.ok(SurgeonDataService.getSurgeonBysurgeonId(surgeonId));
    }

    @PutMapping(value = "/update/{surgeonId}")
    public ResponseEntity<SurgeonData> updateSurgeon(@PathVariable Long surgeonId, @Valid @RequestBody SurgeonData updatedSurgeon) {
        return ResponseEntity.ok(SurgeonDataService.updateSurgeonBysurgeonId(surgeonId, updatedSurgeon));
    }

    @DeleteMapping(value = "/delete/{surgeonId}")
    public ResponseEntity<String> deleteSurgeon(@PathVariable Long surgeonId) {
        return ResponseEntity.ok(SurgeonDataService.deleteSurgeonBysurgeonId(surgeonId));
    }
}