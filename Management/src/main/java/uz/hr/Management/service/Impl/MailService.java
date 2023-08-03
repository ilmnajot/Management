package uz.hr.Management.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Value("${email.base.url}")
    private String url;

    public Boolean sendMail(String email, String link) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-reply2023@gmail.com");
            message.setTo(email);
            message.setSubject("verify the account");
            message.setText(link);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }}
