package tn.esprit.spring.service;

public interface TwillioService {
public void sendSms(String to, String from, String body);
}
