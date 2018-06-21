package com.sms.smssender.controllers;

import com.sms.smssender.service.SMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private SMSSender sender;

    @RequestMapping("/")
    public String showSMSSendingPage() {
        return "main";
    }

    @RequestMapping("/send")
    public ModelAndView sendSMS(ModelAndView view) {
        sender.sendSMS();
        view.setViewName("main");
        view.addObject("success", true);
        return view;
    }
}
