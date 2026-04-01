# 📧 FullStack Email Sender Application

A full-stack Email Sender application built using **Spring Boot**, **JavaMailSender**, **React**, and **Tailwind CSS**.  
This project allows users to send emails via popular email providers such as **Gmail** and **Outlook** using secure SMTP configurations.

---

## 🚀 Features

- 📤 Send emails using Spring Boot REST APIs
- 🌐 Supports Gmail, Outlook, and other SMTP providers
- 🧩 Backend built with Spring Boot and JavaMailSender
- 🎨 Frontend developed using React and Tailwind CSS
- 🔌 RESTful API integration between frontend and backend
- 🧪 Unit testing with Mockito
- 🧾 API testing using Postman
- 🏗️ Clean and modular project structure

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- JavaMailSender
- REST APIs
- Mockito (Unit Testing)

### Frontend
- React
- Tailwind CSS

### Tools & Testing
- Postman
- Git & GitHub

---

## 📂 Project Structure

FullStack-Email-Service
│
├── backend/
│ ├── controller/
│ ├── service/
│ ├── model/
│ ├── config/
│ └── test/
│
├── frontend/
│ ├── src/
│ ├── components/
│ ├── pages/
│ └── services/
│
└── README.md
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
