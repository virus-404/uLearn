package com.example.uLearn.web;

import com.example.uLearn.model.User;
import com.example.uLearn.payload.request.ChangePasswordRequest;
import com.example.uLearn.payload.request.ResetPasswordRequest;
import com.example.uLearn.payload.response.MessageResponse;
import com.example.uLearn.repository.UserRepository;
import com.example.uLearn.security.services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class PasswordController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EmailSender emailSender;


    @PostMapping("/changePassword")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest){

        User user = userRepository.findByUsername(changePasswordRequest.getUsername()).get();
        user.setPassword(encoder.encode(changePasswordRequest.getPassword()));
        userRepository.save(user);
        return  ResponseEntity.ok(new MessageResponse("Password Changed correctly"));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@Valid @RequestParam String email) {
        User user = userRepository.findByUsername(email).get();
        if(user != null) {
            emailSender.sendPasswordEmail(user);
            return ResponseEntity.ok(new MessageResponse("An email has been sent to help you reset your password"));
        }
        else
        {
            return ResponseEntity.ok(new MessageResponse("Email not correct please insert your email in the database"));
        }
    }
    @PostMapping("/changelostPassword")
    public ResponseEntity<?> changeLostPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest){
        User user = userRepository.findByUsername(resetPasswordRequest.getUsername()).get();
        if(Integer.parseInt(resetPasswordRequest.getToken()) == user.getToken() && user != null) {
            return changePassword(new ChangePasswordRequest(resetPasswordRequest.getUsername(),resetPasswordRequest.getPassword()));
        }
        else {
            return ResponseEntity.ok(new MessageResponse("Username or token not valid"));
        }

    }
}
