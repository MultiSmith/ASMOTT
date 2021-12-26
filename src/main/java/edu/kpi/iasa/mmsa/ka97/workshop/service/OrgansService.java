package edu.kpi.iasa.mmsa.ka97.workshop.service;

import edu.kpi.iasa.mmsa.ka97.workshop.model.Organs;
import edu.kpi.iasa.mmsa.ka97.workshop.repository.OrgansRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgansService {
    private final OrgansRepository OrgansRepository;
    public OrgansService(OrgansRepository OrgansRepository) {
        this.OrgansRepository = OrgansRepository;
    }
    public List<Organs> getOrgans() {
        return OrgansRepository.findAll();
    }

    public Organs saveOrgans(Organs newOrgans) {
        return OrgansRepository.save(newOrgans);
    }

    public Organs getOrganByorganId(Long organId) {
        Optional<Organs> organ = OrgansRepository.findById(organId);
        return organ.get();
    }

    public Organs updateOrganByorganId(Long organId, Organs updatedOrgan) {
        Optional<Organs> organ = OrgansRepository.findById(organId);
        Organs oldOrgan = organ.get();
        updateOrgan(oldOrgan, updatedOrgan);
        return OrgansRepository.save(oldOrgan);
    }

    private void updateOrgan(Organs oldOrgan, Organs updatedOrgan) {
        oldOrgan.setOrgan_name(updatedOrgan.getOrgan_name());
    }

    public String deleteOrganByorganId(Long organId) {
        OrgansRepository.deleteById(organId);
        return "Mentioned organ was deleted!";
    }
}
