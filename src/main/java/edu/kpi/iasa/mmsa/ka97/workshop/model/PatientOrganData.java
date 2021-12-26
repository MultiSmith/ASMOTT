package edu.kpi.iasa.mmsa.ka97.workshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Entity
@Table(name = "patient_organ_data")
public class PatientOrganData {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    @NotNull
    private String fathersname;
    @NotNull
    private Integer organ_type;
    @NotNull
    private Long clinic_id;
    @NotNull
    @Column(columnDefinition = "ENUM('FIRST', 'SECOND', 'THIRD', 'FOURTH')")
    @Enumerated(EnumType.STRING)
    private BloodType blood_type;
    @NotNull
    @Column(columnDefinition = "ENUM('PLUS', 'MINUS')")
    @Enumerated(EnumType.STRING)
    private ResusFactor resus_factor;
    @NotNull
    private Timestamp date;
    @Column(unique = true)
    private Long id_code;
    @NotNull
    @Column(columnDefinition = "ENUM('DONOR', 'RECIPIENT')")
    @Enumerated(EnumType.STRING)
    private DonorOrRecip donor_or_recip;
    @NotNull
    @Column(columnDefinition = "ENUM('WAITING', 'DEAD', 'OPERATED')")
    @Enumerated(EnumType.STRING)
    private StatusForPatients status;

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public Integer getOrgan_type() {
        return organ_type;
    }

    public void setOrgan_type(Integer organ_type) {
        this.organ_type = organ_type;
    }

    public Long getClinic_id() {
        return clinic_id;
    }

    public void setClinic_id(Long clinic_id) {
        this.clinic_id = clinic_id;
    }

    public BloodType getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(BloodType blood_type) {
        this.blood_type = blood_type;
    }

    public ResusFactor getResus_factor() {
        return resus_factor;
    }

    public void setResus_factor(ResusFactor resus_factor) {
        this.resus_factor = resus_factor;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId_code() {
        return id_code;
    }

    public void setId_code(Long id_code) {
        this.id_code = id_code;
    }

    public DonorOrRecip getDonor_or_recip() {
        return donor_or_recip;
    }

    public void setDonor_or_recip(DonorOrRecip donor_or_recip) {
        this.donor_or_recip = donor_or_recip;
    }

    public StatusForPatients getStatus() {
        return status;
    }

    public void setStatus(StatusForPatients status) {
        this.status = status;
    }
}
