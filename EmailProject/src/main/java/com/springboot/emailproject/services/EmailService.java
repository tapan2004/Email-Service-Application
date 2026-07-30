package com.springboot.emailproject.services;

import java.io.File;

public interface EmailService {
    void SendEmailSingleUser(String to, String subject, String message); // send emails to single person

    void sendEmailMultipleUsers(String[] to, String subject, String message); // send emails to multiple person

    void sendEmailWithHtml(String to, String subject, String htmlContent);

    void sendEmailWithFile(String to, String subject, String message, File file);//
}
