package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.service.EventService;

@RestController
@RequestMapping("/Event")
public class EventRestController {
	@Autowired
	EventService ES;
	// http://localhost:8081/SpringMVC/servlet/Event/add-event
			@PostMapping("/add-event")
			@ResponseBody
			public Event saveEvent(@RequestBody Event even) {
			Event event = ES.save(even);
			return event;
			}
			// http://localhost:8081/SpringMVC/servlet/Event/retrieve-all-Events
			@GetMapping("/retrieve-all-Events")
			@ResponseBody
			public List<Event> getEvents() {
			List<Event> list = ES.retrieveAllEvent();
			return list;
			}
			// http://localhost:8081/SpringMVC/servlet/Event/remove-Event/{event-id}
			@DeleteMapping("/remove-Event/{event-id}")
			@ResponseBody
			public void removeEvent(@PathVariable("event-id") long eventId) {
			ES.deleteEvent(eventId);
			}
			// http://localhost:8081/SpringMVC/servlet/Event/modify-Event
			@PutMapping("/modify-Event")
			@ResponseBody
			public Event modifyevent(@RequestBody Event even) {
			return ES.updateEvent(even);
			}
}
