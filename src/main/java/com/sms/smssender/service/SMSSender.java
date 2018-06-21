package com.sms.smssender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class SMSSender {

    private String account_sid = "AC3ca5675b9208c06354e10170e614cecb";
    private String auth_token = "deba3a0bf3361e1a61a94e1be02adcad";

    @Autowired
    private RestTemplate restTemplate;

    public void sendSMS() {
        String uri = "https://api.twilio.com/2010-04-01/Accounts/" + account_sid + "/Messages";
        String userAndPass = account_sid + ":" + auth_token;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString(userAndPass.getBytes()));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Body", "\u200Apå de elementära පරීක්ෂණ වචනය .");
        map.add("From", "+15614754307");
//        map.add("To", "+94771544792");
        map.add("To", "+94710611810");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        System.out.println(response.getBody());
    }
}
