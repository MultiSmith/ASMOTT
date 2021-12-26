package edu.kpi.iasa.mmsa.ka97.workshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Entity
@Table(name = "surgeon_data")
public class SurgeonData {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "surgeon_id")
    private Long surgeonId;
    @NotNull
    @Column(name = "clinic_id")
    private Long clinicId;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    @NotNull
    private String fathersname;
    @Column(unique = true)
    private Long id_code;

    public Long getSurgeonId() {
        return surgeonId;
    }

    public void setSurgeonId(Long surgeonId) {
        this.surgeonId = surgeonId;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
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

    public Long getId_code() {
        return id_code;
    }

    public void setId_code(Long id_code) {
        this.id_code = id_code;
    }
}
