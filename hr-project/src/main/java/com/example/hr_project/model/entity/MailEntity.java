package com.example.hr_project.model.entity;

import com.example.hr_project.model.enums.CompanyIndustry;
import com.example.hr_project.model.enums.MailStatus;
import com.example.hr_project.model.enums.Role;
import com.example.hr_project.model.enums.WorkingModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "mail")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("privateName")
    private String private_name;

    @JsonProperty("companyName")
    private String company_name;

    @NotNull
    private String mail;

    @NotNull
    @JsonProperty("companyIndustry")
    private CompanyIndustry company_industry;

    private MailStatus status;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    @JsonProperty("workingModel")
    private WorkingModel working_model;

    @JsonProperty("location")
    private String company_location;

    private boolean isMailPersonal;

    private int employeeCount;

    private double workingTenure;



}
