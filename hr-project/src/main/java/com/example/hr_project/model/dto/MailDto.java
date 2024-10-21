package com.example.hr_project.model.dto;

import com.example.hr_project.model.enums.CompanyIndustry;
import com.example.hr_project.model.enums.MailStatus;
import com.example.hr_project.model.enums.Role;
import com.example.hr_project.model.enums.WorkingModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MailDto {
    private Long id;

    private String private_name;

    private String company_name;

    private String mail;

    private CompanyIndustry company_industry;

    private MailStatus status;

    private Role role;

    private WorkingModel working_model;

    private String company_location;

    private boolean isMailPersonal;

    private int employeeCount;

    private double workingTenure;
}

