package com.example.uLearn.security.services;

import com.example.uLearn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(User user) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());

        msg.setSubject("uLearn Activation email");
        msg.setText("Dear " +user.getUsername()+"\n email account not verified");

        javaMailSender.send(msg);

    }
}
