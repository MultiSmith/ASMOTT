package edu.kpi.iasa.mmsa.ka97.workshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Entity
@Table(name = "clinic_data")
public class ClinicData {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    private Long clinicId;
    @NotNull
    private String address;
    @NotNull
    private String city;

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}