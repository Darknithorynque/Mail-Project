package com.example.hr_project.model.dto;

public class MailSendDto {

    private Long id;
    private String to;
    private String subject;
    private String content;
    private String filePath;



    public MailSendDto(Long id, String to, String subject, String content, String filePath) {
        this.id = id;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.filePath = filePath;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
