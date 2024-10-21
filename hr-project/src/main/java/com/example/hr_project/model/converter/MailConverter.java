package com.example.hr_project.model.converter;

import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.entity.MailEntity;
import com.example.hr_project.model.request.MailRequestFilterDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MailConverter implements Converter<MailEntity, MailDto> {

    @Override
    public MailDto convert(MailEntity mailEntity) {
        if(mailEntity == null){
            return null;
        }
        return MailDto.builder()
                .id(mailEntity.getId())
                .private_name(mailEntity.getPrivate_name())
                .company_name(mailEntity.getCompany_name())
                .mail(mailEntity.getMail())
                .company_industry(mailEntity.getCompany_industry())
                .status(mailEntity.getStatus())
                .role(mailEntity.getRole())
                .working_model(mailEntity.getWorking_model())
                .company_location(mailEntity.getCompany_location())
                .isMailPersonal(mailEntity.isMailPersonal())
                .employeeCount(mailEntity.getEmployeeCount())
                .workingTenure(mailEntity.getWorkingTenure())
                .build();
    }

}
