package com.springboot.emailproject.servicesImp;

import com.springboot.emailproject.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImp implements EmailService {

    private final JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(EmailServiceImp.class);

    public EmailServiceImp(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void SendEmailSingleUser(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("tabc1196@gmail.com");

        javaMailSender.send(simpleMailMessage);
        logger.info("Email has been Sent..");
    }

    @Override
    public void sendEmailMultipleUsers(String[] to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("tabc1196@gmail.com");

        javaMailSender.send(simpleMailMessage);
        logger.info("Email has been sent for multiUser..");
    }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("tabc1196@gmail.com");
            helper.setText("This email contains HTML content",htmlContent); // true = HTML

            javaMailSender.send(mimeMessage);
            logger.info("HTML Email has been sent with Html");

        } catch (MessagingException e) {
            logger.error("Error while sending HTML email", e);
        }
    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setFrom("tabc1196@gmail.com");
            messageHelper.setText(message);
            messageHelper.addAttachment(file.getName(), file);

            javaMailSender.send(mimeMessage);
            logger.info("Email with attachment sent");
        } catch (MessagingException e) {
            logger.error("Failed to send email with attachment", e);
        }
    }
}
