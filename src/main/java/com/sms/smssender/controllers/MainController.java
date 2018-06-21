package com.sms.smssender.controllers;

import com.sms.smssender.service.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private SMSSender sender;

    @RequestMapping("/")
    public String showSMSSendingPage() {
        return "main";
    }

    @RequestMapping("/send")
    public String sendSMS() {
        sender.sendSMS();
        return "main";
    }
}
