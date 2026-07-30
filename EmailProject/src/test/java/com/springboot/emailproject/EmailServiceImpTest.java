//package com.springboot.emailproject;
//
//import com.springboot.emailproject.services.EmailService;
//import com.springboot.emailproject.servicesImp.EmailServiceImp;
//import jakarta.mail.Session;
//import jakarta.mail.internet.MimeMessage;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//
//import java.io.File;
//import java.util.Properties;
//
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class EmailServiceImpTest {
//
//   @Autowired
//   private EmailService emailService;
//
//    @Test
//    void testSendEmailSingleUser() {
//        System.out.println("Sending Email from Single user");
//        emailService.SendEmailSingleUser(
//                "mtapan2004@gmail.com",
//                "Email from springBoot",
//                "This email is send using spring boot while create email service"
//        );
//    }
//
//    @Test
//    void testSendEmailMultipleUsers() {
//        System.out.println("Sending Email from Multi-user");
//        String[] users = {
//                "mtapan2004@gmail.com",
//                "mannatapan584@gmail.com",
//                "tmanna23@outlook.com"
//        };
//        emailService.sendEmailMultipleUsers(
//                users,
//                "Email from springBoot",
//                "This email is send using spring boot while create email service for multi-user"
//        );
//    }
//
//    @Test
//    void testSendEmailWithHtml() {
//        MimeMessage mimeMessage = new MimeMessage((Session.getDefaultInstance(new Properties())));
//        String html = "<h1 style='color:red'> Good Afternoon, Tapan</h1>";
//        System.out.println("Sending HTML Email");
//
//        emailService.sendEmailWithHtml(
//                "mtapan2004@gmail.com",
//                "Email From Spring Boot - HTML",
//                html
//        );
//    }
//    @Test
//    void testSendEmailWithAttachment() {
//        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(new Properties()));
//        File file = new File("C:\\Users\\Tapan Manna\\Downloads\\2550.gif");
//        emailService.sendEmailWithFile(
//                "mtapan2004@gmail.com",
//                "Email from springBoot",
//                "Please see attachment",
//                file
//        );
//    }
//}