package com.aicall.schedulo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TwimlController {

    @RequestMapping(value = "/twiml", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_XML_VALUE)
    public String getTwiml() {
        System.out.println("✅ TwiML endpoint hit by Twilio");

        return """
               <?xml version="1.0" encoding="UTF-8"?>
               <Response>
                   <Say voice="alice">Hi Rahul, your interview is scheduled for Thursday at 3 PM. Good luck!</Say>
               </Response>
               """;
    }
}
