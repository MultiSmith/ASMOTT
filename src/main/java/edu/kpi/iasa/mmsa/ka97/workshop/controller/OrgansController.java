package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.Organs;
import edu.kpi.iasa.mmsa.ka97.workshop.service.OrgansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/organs")
public class OrgansController {

    private final OrgansService OrgansService;

    @Autowired
    public OrgansController(OrgansService OrgansService) {
        this.OrgansService = OrgansService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Organs>> getOrgans() {
        return ResponseEntity.ok(OrgansService.getOrgans());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Organs> postOrgans(@Valid @RequestBody Organs newOrgans) {
        return ResponseEntity.ok(OrgansService.saveOrgans(newOrgans));
    }

    @GetMapping(value = "/getById/{organId}")
    public ResponseEntity<Organs> getOrgan(@PathVariable Long organId) {
        return ResponseEntity.ok(OrgansService.getOrganByorganId(organId));
    }

    @PutMapping(value = "/update/{organId}")
    public ResponseEntity<Organs> updateOrgan(@PathVariable Long organId, @Valid @RequestBody Organs updatedOrgan) {
        return ResponseEntity.ok(OrgansService.updateOrganByorganId(organId, updatedOrgan));
    }

    @DeleteMapping(value = "/delete/{organId}")
    public ResponseEntity<String> deleteOrgan(@PathVariable Long organId) {
        return ResponseEntity.ok(OrgansService.deleteOrganByorganId(organId));
    }
}
