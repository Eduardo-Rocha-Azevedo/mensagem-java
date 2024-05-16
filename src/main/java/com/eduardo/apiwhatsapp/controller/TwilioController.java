package com.eduardo.apiwhatsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eduardo.apiwhatsapp.Smsrequest;
import com.eduardo.apiwhatsapp.service.Smsservice;

@Controller
public class TwilioController {

    private Smsservice smsservice;

    @Autowired
    public TwilioController(Smsservice smsservice) {
        this.smsservice = smsservice;
    }

    @GetMapping("/")
    public ModelAndView homepage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/sendmessage")
    public ResponseEntity<Object> sendmessage(Smsrequest smsrequest) {
        String status = smsservice.sendsms(smsrequest);
        if ("sent".equals(status) || "queued".equals(status)) {
            return new ResponseEntity<Object>("sent successfully", HttpStatus.OK);
        }
        return new ResponseEntity<Object>("failed to send message", HttpStatus.NOT_FOUND);
    }
}
