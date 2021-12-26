package edu.kpi.iasa.mmsa.ka97.workshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Entity
@Table(name = "donor_recipient_pair")
public class DonorRecipientPair {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pair_id")
    private Long pairId;
    @NotNull
    private Long patient_id_1;
    @NotNull
    private Long patient_id_2;
    @NotNull
    @Column(columnDefinition = "ENUM('PENDING', 'CANCELLED', 'DONE')")
    @Enumerated(EnumType.STRING)
    private StatusForPairs status;
    private Timestamp date;

    public Long getPairId() {
        return pairId;
    }

    public void setPairId(Long pairId) {
        this.pairId = pairId;
    }

    public Long getPatient_id_1() {
        return patient_id_1;
    }

    public void setPatient_id_1(Long patient_id_1) {
        this.patient_id_1 = patient_id_1;
    }

    public Long getPatient_id_2() {
        return patient_id_2;
    }

    public void setPatient_id_2(Long patient_id_2) {
        this.patient_id_2 = patient_id_2;
    }

    public StatusForPairs getStatus() {
        return status;
    }

    public void setStatus(StatusForPairs status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}