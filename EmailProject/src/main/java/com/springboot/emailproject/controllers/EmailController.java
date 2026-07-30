package com.springboot.emailproject.controllers;

import com.springboot.emailproject.dto.EmailRequest;
import com.springboot.emailproject.helper.EmailHelper;
import com.springboot.emailproject.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-user")
    public ResponseEntity<?> sendEmailSingleUser(
            @RequestBody EmailRequest request) {
        emailService.SendEmailSingleUser(
                request.getTo(),
                request.getSubject(),
                request.getMessage()
        );
        return ResponseEntity.ok(
                EmailHelper.builder()
                        .message("Email send Successfully !!")
                        .httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-users")
    public ResponseEntity<EmailHelper> sendEmailMultipleUsers(@RequestBody EmailRequest request) {
        emailService.sendEmailMultipleUsers(
                request.getToList(),
                request.getSubject(),
                request.getMessage()
        );
        return ResponseEntity.ok(
                EmailHelper.builder()
                        .message("Email sent to multiple users successfully!!")
                        .httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-html")
    public ResponseEntity<EmailHelper> sendEmailWithHtml(@RequestBody EmailRequest request) {
        emailService.sendEmailWithHtml(
                request.getTo(),
                request.getSubject(),
                request.getMessage()
        );
        return ResponseEntity.ok(
                EmailHelper.builder()
                        .message("HTML Email sent successfully !!")
                        .httpStatus(HttpStatus.OK).success(true).build()
        );
    }

    @PostMapping("/send-file")
    public ResponseEntity<EmailHelper> sendEmailWithAttachment(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam("file") MultipartFile file)
            throws IOException {
        File tempFile = File.createTempFile(
                "email", file.getOriginalFilename());
        file.transferTo(tempFile);

        emailService.sendEmailWithFile(
                to,
                subject,
                message,
                tempFile
        );
        return ResponseEntity.ok(
                EmailHelper.builder()
                        .message("Email with attachment sent successfully")
                        .httpStatus(HttpStatus.OK).success(true).build()
        );
    }
}


