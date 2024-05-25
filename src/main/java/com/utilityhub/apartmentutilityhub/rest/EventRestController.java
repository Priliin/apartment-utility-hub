package com.utilityhub.apartmentutilityhub.rest;


import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.service.impl.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This controller is responsible for handling HTTP requests related to Event entities.
@RestController
@RequestMapping("/api")
public class EventRestController {

    private final EventServiceImpl eventService;

    // Constructor for the controller that uses constructor injection
    // to set the eventService dependency.
    public EventRestController(EventServiceImpl eventService) {
       this.eventService = eventService;
    }

    // Retrieve all events
    @GetMapping("/all")
    public List<EventDTO> findAllInfo() {
    return eventService.findAllEvents();
    }

    // Annotation to define an endpoint where {id} is a
    // variable part of the URL path representing an event’s ID.
    @GetMapping("/{id}")
    public EventDTO infoDetails(@PathVariable  Long id) {
        EventDTO event = eventService.findEventById(id);
        if(id == null) {
            throw new RuntimeException("Event not found");
        }else {
            return event;
        }
    }
}
