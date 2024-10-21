package com.example.hr_project.model.converter;

import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.entity.MailEntity;
import com.example.hr_project.model.request.MailRequestFilterDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MailDtoConverter implements Converter<MailDto, MailEntity> {

    @Override
    public MailEntity convert(MailDto mailDto) {
        if(mailDto == null){
            return null;
        }
        return MailEntity.builder()
                .private_name(mailDto.getPrivate_name())
                .company_name(mailDto.getCompany_name())
                .mail(mailDto.getMail())
                .company_industry(mailDto.getCompany_industry())
                .status(mailDto.getStatus())
                .role(mailDto.getRole())
                .working_model(mailDto.getWorking_model())
                .company_location(mailDto.getCompany_location())
                .isMailPersonal(mailDto.isMailPersonal())
                .employeeCount(mailDto.getEmployeeCount())
                .workingTenure(mailDto.getWorkingTenure())
                .build();
    }





}
