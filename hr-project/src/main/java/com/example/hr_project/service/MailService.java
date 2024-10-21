package com.example.hr_project.service;

import com.example.hr_project.dao.MailDao;
import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.entity.MailEntity;
import com.example.hr_project.model.enums.MailStatus;
import com.example.hr_project.model.request.MailRequestFilterDto;
import com.example.hr_project.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private final MailDao mailDao;

    @Autowired
    private final MailRepository mailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Page<MailDto> getMailAll(Pageable pageable, MailRequestFilterDto mailRequestFilterDto){
        return mailDao.getAllMail(pageable, mailRequestFilterDto);
    }

    public MailDto createMail(MailDto mailDto){
        return mailDao.createMail(mailDto);
    }

    public Optional<MailDto> getMailById(Long id){
        return mailDao.getMailById(id);
    }

    public MailDto updateMail(Long id, MailDto mailDto) {
        Optional<MailDto> mail = mailDao.getMailById(id);
        if(!mail.isPresent()){
            throw new IllegalArgumentException("User Not Found");
        }
        return mailDao.updateMail(id,mailDto);
    }

    public void sendMail(Long id, String to, String subject, String content, String filePath){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);

            String formattedContent = content.replace("\n", "<br>");
            helper.setText(formattedContent, true);

            File pdfFile = new File(filePath);
            helper.addAttachment(pdfFile.getName(), pdfFile);

            Optional<MailEntity> mail = mailRepository.findById(id);
            if (mail.isPresent()) {
                MailEntity mailEntity = mail.get();
                mailEntity.setStatus(MailStatus.SENT);
                mailRepository.save(mailEntity);
            }
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void deleteMailById(Long id){
        mailDao.deleteMailById(id);
    }

}
