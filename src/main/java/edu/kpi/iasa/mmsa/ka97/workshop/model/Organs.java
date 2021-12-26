package edu.kpi.iasa.mmsa.ka97.workshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.*;

@Entity
@Table(name = "organs")
public class Organs {
    @NotNull
    @Id
    @Column(name = "organ_id")
    private Long organId;
    @NotNull
    private String organ_name;

    public Long getOrganId() {
        return organId;
    }

    public void setOrganId(Long organId) {
        this.organId = organId;
    }

    public String getOrgan_name() {
        return organ_name;
    }

    public void setOrgan_name(String organ_name) {
        this.organ_name = organ_name;
    }

}