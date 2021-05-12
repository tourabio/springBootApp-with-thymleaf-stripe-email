package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
@Autowired
EventRepository Er;
private static final Logger L =  LogManager.getLogger(EventServiceImpl.class);
@Override
public Event save(Event event) {
	// TODO Auto-generated method stub
	return Er.save(event);
}

@Override
public List<Event> retrieveAllEvent() {
	// TODO Auto-generated method stub
	List<Event> events = (List<Event>) Er.findAll();
	for (Event event : events){
	L.info("event +++: " + event );}
	return events;

}

@Override
public void deleteEvent(long id) {
	// TODO Auto-generated method stub
	Optional<Event> event = Er.findById(id);
    
    if(event.isPresent()) 
    {
        Er.deleteById(id);}	
}

@Override
public Event updateEvent(Event even) {
	// TODO Auto-generated method stub
	return Er.save(even);
}
/*@Override
public Event updateEvent(Event even) {
	// TODO Auto-generated method stub
	Optional<Event> event = Er.findById(even.getId());
	if(event.isPresent()) 
    {
	     Event newEvent = event.get();
        newEvent.setEventname(even.getEventname());
        newEvent.setEndsdate(even.getEndsdate());
        newEvent.setStartdate(even.getStartdate());
       
         
        return newEvent;
    } else {
        even = Er.save(even);
         
        return even;
    }
}*/
	



}
