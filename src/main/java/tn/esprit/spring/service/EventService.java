package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Event;

public interface EventService {
	public Event save(Event event);
	List<Event> retrieveAllEvent();
	void deleteEvent(long id);
	Event updateEvent(Event even);
	
	//Contract retrieveContract(long id);
	
}
