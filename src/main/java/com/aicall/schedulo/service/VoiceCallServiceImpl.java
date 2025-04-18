package com.aicall.schedulo.service;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

/**
 * Service to trigger a Twilio voice call with dynamic message.
 */
@Service
public class VoiceCallServiceImpl implements VoiceCallService {

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @Override
    public String initiateCall(String toPhoneNumber, String message) {
        // TwiML Bin or dynamic endpoint URL that returns TwiML XML
        URI twimlUri = URI.create("http://01js48az855p2q9c5gj6e8wcsc.webrelay.io/twiml");

        System.out.println("🔁 Calling Twilio with TwiML URL: " + twimlUri);



        Call call = Call.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                twimlUri
        ).create();

        return "Call initiated, SID: " + call.getSid();
    }
}
