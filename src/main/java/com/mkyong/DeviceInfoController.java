package com.mkyong;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;

@RestController
public class DeviceInfoController {

	public static final String ACCOUNT_SID = "AC766b60408feb07e32867e683fbb600e9";
	public static final String AUTH_TOKEN = "fd8667ebac199f98c9948e2aff971f72";

	@GetMapping("/sendSMSoverTwilio")
	public String sendSMSoverTwilio() {
		String messageSentStaus = null;
		TwilioRestClient twilioRestClient = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		Account account = twilioRestClient.getAccount();
		SmsFactory factory = account.getSmsFactory();
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("To", "+918884631730");
		messageMap.put("From", "+919502106030");
		messageMap.put("Body", "Hello! This is Anil from Twilio & Thanks Twilio!");
		try {
			factory.create(messageMap);
			messageSentStaus = "Success!";
		} catch (TwilioRestException e) {
			messageSentStaus = e.getErrorMessage();
		}

		return messageSentStaus;

	}

}
