package com.example.hr_project.dao.impl;

import com.example.hr_project.dao.MailDao;
import com.example.hr_project.model.converter.MailConverter;
import com.example.hr_project.model.converter.MailDtoConverter;
import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.entity.MailEntity;
import com.example.hr_project.model.request.MailRequestFilterDto;
import com.example.hr_project.repository.MailRepository;
import com.example.hr_project.repository.specification.MailSpecification;
import com.example.hr_project.utils.UpdateHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MailDaoImpl implements MailDao {

    @Autowired
    private final MailRepository mailRepository;

    @Autowired
    private final MailConverter mailConverter;

    @Autowired
    private final MailDtoConverter mailDtoConverter;

    public Specification<MailEntity> getSpecification(MailRequestFilterDto filter) {
        Specification<MailEntity> spec = Specification.where(null);

        if (filter.getCompany_name() != null && !filter.getCompany_name().isEmpty()) {
            spec = spec.and(MailSpecification.hasCompanyName(filter.getCompany_name()));
        }

        if (filter.getPrivate_name() != null && !filter.getPrivate_name().isEmpty()) {
            spec = spec.and(MailSpecification.hasPrivateName(filter.getPrivate_name()));
        }

        if (filter.getCompany_industry() != null) {
            spec = spec.and(MailSpecification.hasCompanyIndustry(filter.getCompany_industry()));
        }

        if (filter.getStatus() != null) {
            spec = spec.and(MailSpecification.hasStatus(filter.getStatus()));
        }

        if (filter.getRole() != null) {
            spec = spec.and(MailSpecification.hasRole(filter.getRole()));
        }

        if (filter.getWorking_model() != null) {
            spec = spec.and(MailSpecification.hasWorkingModel(filter.getWorking_model()));
        }

        if (filter.getMinEmpCount() >= 0) {
            spec = spec.and(MailSpecification.hasEmployeeCount(filter.getMinEmpCount(), filter.getMaxEmpCount()));
        }

        if (filter.getMinWorkingTenure() >= 0) {
            spec = spec.and(MailSpecification.hasWorkingTenure(filter.getMinWorkingTenure(), filter.getMaxWorkingTenure()));
        }

        return spec;
    }

    @Override
    public Page<MailDto> getAllMail(Pageable pageable, MailRequestFilterDto mailRequestFilterDto){
        Specification<MailEntity> spec = Specification.where(null);

        if (mailRequestFilterDto != null) {

            spec = getSpecification(mailRequestFilterDto);

        }
        Page<MailEntity> mailEntities = mailRepository.findAll(spec, pageable);

        return mailEntities.map(mailConverter::convert);
    }




    @Override
    public MailDto createMail(MailDto mailDto){

        MailEntity mailEntityConverted = mailDtoConverter.convert(mailDto);

        assert mailEntityConverted != null;
        MailEntity mailEntity = mailRepository.save(mailEntityConverted);

        return mailConverter.convert(mailEntity);
    }

    @Override
    public Optional<MailDto> getMailById(Long id){

        return mailRepository.findById(id)
                .map(mailConverter::convert);
    }

    @Override
    public MailDto updateMail(Long id, MailDto mailDto){

       MailEntity theMail = mailRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("User not found"));

        UpdateHelper.updateField(theMail::getMail, theMail::setMail, mailDto.getMail());
        UpdateHelper.updateField(theMail::getPrivate_name, theMail::setPrivate_name, mailDto.getPrivate_name());
        UpdateHelper.updateField(theMail::getCompany_name, theMail::setCompany_name, mailDto.getCompany_name());
        UpdateHelper.updateField(theMail::getCompany_location, theMail::setCompany_location, mailDto.getCompany_location());
        UpdateHelper.updateField(theMail::getStatus, theMail::setStatus, mailDto.getStatus());
        UpdateHelper.updateField(theMail::getRole, theMail::setRole, mailDto.getRole());
        UpdateHelper.updateField(theMail::getWorking_model, theMail::setWorking_model, mailDto.getWorking_model());
        UpdateHelper.updateField(theMail::isMailPersonal, theMail::setMailPersonal, mailDto.isMailPersonal());
        UpdateHelper.updateField(theMail::getEmployeeCount, theMail::setEmployeeCount, mailDto.getEmployeeCount());
        UpdateHelper.updateField(theMail::getWorkingTenure, theMail::setWorkingTenure, mailDto.getWorkingTenure());

        MailEntity updatedMail = mailRepository.save(theMail);

        return mailConverter.convert(updatedMail);
    }

    @Override
    public void deleteMailById(Long id){
        MailEntity theMail = mailRepository.findById(id).orElse(null);

        if(theMail != null){
            mailRepository.delete(theMail);
        }

    }

    @Override
    public void save(MailDto mailDto){
        MailEntity covertMail =  mailDtoConverter.convert(mailDto);
        assert covertMail != null;
        mailRepository.save(covertMail);

    }

}
