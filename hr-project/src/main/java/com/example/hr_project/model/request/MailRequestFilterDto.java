package com.example.hr_project.model.request;

import com.example.hr_project.model.enums.CompanyIndustry;
import com.example.hr_project.model.enums.MailStatus;
import com.example.hr_project.model.enums.Role;
import com.example.hr_project.model.enums.WorkingModel;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequestFilterDto {
    private String company_name;
    private String private_name;
    private CompanyIndustry company_industry;
    private MailStatus status;
    private WorkingModel working_model;
    private boolean isMailPersonal;
    private Role role;
    private int minEmpCount;
    private int maxEmpCount;
    private double minWorkingTenure;
    private double maxWorkingTenure;

}
