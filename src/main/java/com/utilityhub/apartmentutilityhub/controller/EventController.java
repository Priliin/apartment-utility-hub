package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.service.impl.EventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/info")
public class EventController {
    private final EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }
    //Information page
    @GetMapping()
    public String infoPage(ModelMap model) {
        List<EventDTO> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "event-info";
    }
    @GetMapping("/{id}")
    public String infoDetails(@PathVariable("id") Long id, ModelMap model) {
        EventDTO event= eventService.findEventById(id);
        model.addAttribute("event", event);
        return "event-details";
    }
}

