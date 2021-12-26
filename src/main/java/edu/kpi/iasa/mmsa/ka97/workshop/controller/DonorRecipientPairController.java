package edu.kpi.iasa.mmsa.ka97.workshop.controller;

import edu.kpi.iasa.mmsa.ka97.workshop.model.DonorRecipientPair;
import edu.kpi.iasa.mmsa.ka97.workshop.model.DonorRecipientPair;
import edu.kpi.iasa.mmsa.ka97.workshop.service.DonorRecipientPairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/donor_recipient_pair")
public class DonorRecipientPairController {

    private final DonorRecipientPairService DonorRecipientPairService;

    @Autowired
    public DonorRecipientPairController(DonorRecipientPairService DonorRecipientPairService) {
        this.DonorRecipientPairService = DonorRecipientPairService;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<DonorRecipientPair>> getDonorRecipientPair() {
        return ResponseEntity.ok(DonorRecipientPairService.getDonorRecipientPair());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<DonorRecipientPair> postDonorRecipientPair(@Valid @RequestBody DonorRecipientPair newDonorRecipientPair) {
        return ResponseEntity.ok(DonorRecipientPairService.saveDonorRecipientPair(newDonorRecipientPair));
    }

    @GetMapping(value = "/getById/{pairId}")
    public ResponseEntity<DonorRecipientPair> getADonorRecipientPair(@PathVariable Long pairId) {
        return ResponseEntity.ok(DonorRecipientPairService.getDonorRecipientPairBypairId(pairId));
    }

    @PutMapping(value = "/update/{pairId}")
    public ResponseEntity<DonorRecipientPair> updateADonorRecipientPair(@PathVariable Long pairId, @Valid @RequestBody DonorRecipientPair updatedDonorRecipientPair) {
        return ResponseEntity.ok(DonorRecipientPairService.updateDonorRecipientPairBypairId(pairId, updatedDonorRecipientPair));
    }

    @DeleteMapping(value = "/delete/{pairId}")
    public ResponseEntity<String> deleteADonorRecipientPair(@PathVariable Long pairId) {
        return ResponseEntity.ok(DonorRecipientPairService.deleteDonorRecipientPairBypairId(pairId));
    }
}