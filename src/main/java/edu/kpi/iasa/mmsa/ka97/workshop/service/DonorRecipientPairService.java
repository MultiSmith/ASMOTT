package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.DonorRecipientPair;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.DonorRecipientPairRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorRecipientPairService {
    private final DonorRecipientPairRepository DonorRecipientPairRepository;
    public DonorRecipientPairService(DonorRecipientPairRepository DonorRecipientPairRepository) {
        this.DonorRecipientPairRepository = DonorRecipientPairRepository;
    }
    public List<DonorRecipientPair> getDonorRecipientPair() {
        return DonorRecipientPairRepository.findAll();
    }

    public DonorRecipientPair saveDonorRecipientPair(DonorRecipientPair newDonorRecipientPair) {
        return DonorRecipientPairRepository.save(newDonorRecipientPair);
    }

    public DonorRecipientPair getDonorRecipientPairBypairId(Long pairId) {
        Optional<DonorRecipientPair> pair = DonorRecipientPairRepository.findById(pairId);
        return pair.get();
    }

    public DonorRecipientPair updateDonorRecipientPairBypairId(Long pairId, DonorRecipientPair updatedPair) {
        Optional<DonorRecipientPair> pair = DonorRecipientPairRepository.findById(pairId);
        DonorRecipientPair oldPair = pair.get();
        updateDonorRecipientPair(oldPair, updatedPair);
        return DonorRecipientPairRepository.save(oldPair);
    }

    private void updateDonorRecipientPair(DonorRecipientPair oldPair, DonorRecipientPair updatedPair) {
        oldPair.setPatient_id_1(updatedPair.getPatient_id_1());
        oldPair.setPatient_id_2(updatedPair.getPatient_id_2());
        oldPair.setStatus(updatedPair.getStatus());
        oldPair.setDate(updatedPair.getDate());
    }

    public String deleteDonorRecipientPairBypairId(Long pairId) {
        DonorRecipientPairRepository.deleteById(pairId);
        return "Mentioned pair was deleted!";
    }
}
