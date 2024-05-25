package com.utilityhub.apartmentutilityhub.rest;


import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.service.impl.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EventRestController {

    private final EventServiceImpl eventService;
    public EventRestController(EventServiceImpl eventService) {
       this.eventService = eventService;
    }


    @GetMapping("/all")
    public List<EventDTO> findAllInfo() {
    return eventService.findAllEvents();
    }


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
