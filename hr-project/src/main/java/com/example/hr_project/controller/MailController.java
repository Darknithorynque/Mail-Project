package com.example.hr_project.controller;

import com.example.hr_project.model.dto.MailDto;
import com.example.hr_project.model.dto.MailSendDto;
import com.example.hr_project.model.request.MailRequestFilterDto;
import com.example.hr_project.service.MailService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private final MailService mailService;

    @PostMapping("/search")
    public Page<MailDto> getAllMail(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "8") int size,@Nullable @RequestBody MailRequestFilterDto mailRequestFilterDto){

        Pageable pageable = PageRequest.of(page, size);
        return mailService.getMailAll(pageable, mailRequestFilterDto);
    }

    @PostMapping("/create")
    public MailDto createMail(@RequestBody MailDto mailDto){
        return mailService.createMail(mailDto);
    }

    @GetMapping("/{id}")
    public Optional<MailDto> getMailById(@PathVariable Long id){
        return mailService.getMailById(id);
    }

    @PutMapping("/{id}")
    public MailDto updateMail(@PathVariable Long id,@RequestBody MailDto mailDto){
        return mailService.updateMail(id, mailDto);
    }

    @PostMapping("/send")
    public String sendMail(@RequestBody MailSendDto mailSendDto){
        mailService.sendMail(mailSendDto.getId(), mailSendDto.getTo(), mailSendDto.getSubject(), mailSendDto.getContent(), mailSendDto.getFilePath());
        return "Mail sent successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMailById(@PathVariable Long id){
        mailService.deleteMailById(id);
    }
}
