package com.springboot.emailproject.dto;

public class EmailRequest {

    private String to;
    private String[] toList;
    private String subject;
    private String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String[] getToList() {
        return toList;
    }

    public void setToList(String[] toList) {
        this.toList = toList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
