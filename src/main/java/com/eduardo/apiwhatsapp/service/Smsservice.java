package com.eduardo.apiwhatsapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.apiwhatsapp.Smsrequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class Smsservice {
    @Autowired
    private Twilioproperties twilioProperties;

    public String sendsms(Smsrequest smsrequest) {
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + smsrequest.getNumber()),
                new com.twilio.type.PhoneNumber("whatsapp:" + twilioProperties.getFromNumber()),
                smsrequest.getMessage()
        ).create();

        return message.getSid();
    }
}
