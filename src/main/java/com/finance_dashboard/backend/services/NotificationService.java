package com.finance_dashboard.backend.services;
import com.finance_dashboard.backend.models.*;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public interface NotificationService {

    void sendUserRegistrationVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException;

    void sendForgotPasswordVerificationEmail(User user) throws MessagingException, UnsupportedEncodingException;

}
