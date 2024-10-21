package com.example.hr_project.repository.specification;

import com.example.hr_project.model.entity.MailEntity;
import com.example.hr_project.model.enums.CompanyIndustry;
import com.example.hr_project.model.enums.MailStatus;
import com.example.hr_project.model.enums.Role;
import com.example.hr_project.model.enums.WorkingModel;
import org.springframework.data.jpa.domain.Specification;

public class MailSpecification {

    public static Specification<MailEntity> hasCompanyName(String companyName){
        return (mail, query, criteriaBuilder) -> {

            if(companyName == null || companyName.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("company_name"),companyName);
        };
    }

    public static Specification<MailEntity> hasPrivateName(String privateName){
        return (mail, query, criteriaBuilder) -> {

            if (privateName == null || privateName.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("private_name"),privateName);
        };
    }

    public static Specification<MailEntity> hasCompanyIndustry(CompanyIndustry companyIndustry){
        return (mail, query, criteriaBuilder) -> {

            if( companyIndustry == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("company_industry"),companyIndustry);
        };
    }

    public static Specification<MailEntity> hasStatus(MailStatus status){
        return (mail, query, criteriaBuilder) -> {

            if( status == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("status"),status);
        };
    }

    public static Specification<MailEntity> hasWorkingModel(WorkingModel workingModel){
        return (mail, query, criteriaBuilder) -> {

            if( workingModel == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("working_model"),workingModel);
        };
    }
    public static Specification<MailEntity> hasRole(Role role){
        return (mail, query, criteriaBuilder) -> {

            if( role == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("role"),role);
        };
    }

    public static Specification<MailEntity> isMailPersonal(Boolean isMailPersonal){
        return (mail, query, criteriaBuilder) -> {

            if( isMailPersonal == null ){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(mail.get("isMailPersonal"),isMailPersonal);
        };
    }

    public static Specification<MailEntity> hasEmployeeCount(int min, int max){
        return (mail, query, criteriaBuilder) -> {
            if (min < 0 || max == 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(mail.get("employeeCount"), min, max);
        };
    }


    public static Specification<MailEntity> hasWorkingTenure(double min, double max){
        return (mail, query, criteriaBuilder) -> {
            if (min < 0 || max == 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(mail.get("workingTenure"), min, max);
        };
    }

}
