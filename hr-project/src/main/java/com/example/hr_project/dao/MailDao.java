package com.example.hr_project.dao;

import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.request.MailRequestFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MailDao {
    Page<MailDto> getAllMail(Pageable pageable, MailRequestFilterDto mailRequestFilterDto);

    MailDto createMail(MailDto mailDto);

    Optional<MailDto> getMailById(Long id);

    MailDto updateMail( Long id, MailDto mailDto);

    void deleteMailById(Long id);

    void save(MailDto mailDto);
}
