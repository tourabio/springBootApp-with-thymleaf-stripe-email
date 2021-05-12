package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class TwillioServiceImpl implements TwillioService{

	
	@Value("${app.twillio.accountSID}")
	private String ACCOUNT_SID;
	
	@Value("${app.twillio.authToken}")
	private String AUTH_TOKEN;
	@Override
	public void sendSms(String to,String from,String body) {
		
		try {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
	           // .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
	            //.setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text 
	        		.create();

	        System.out.println(message);
	        System.out.println(message.getSid());

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}}

}
