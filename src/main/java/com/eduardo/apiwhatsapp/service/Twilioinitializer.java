package com.eduardo.apiwhatsapp.service;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Twilioinitializer {
    private final Twilioproperties twilioProperties;

    public Twilioinitializer(Twilioproperties twilioProperties) {
        this.twilioProperties = twilioProperties;
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
        System.out.println("Twilio initialized with account sid:" + twilioProperties.getAccountSid());
    }
}
