package com.example.uLearn.security.services;

import com.example.uLearn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class EmailSender {


    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(User user) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());

        msg.setSubject("uLearn Activation email code-"+user.getToken());
        msg.setText("Dear " +user.getUsername()+"\nemail account not verified"+" insert the code: "+user.getToken()+
                " in the box to activate " + "the email");

        javaMailSender.send(msg);

    }
}
