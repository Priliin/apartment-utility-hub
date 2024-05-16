package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Event;
import com.utilityhub.apartmentutilityhub.service.impl.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        EventDTO event = eventService.findEventById(id);
        model.addAttribute("event", event);
        return "event-details";
    }
    @GetMapping("/addEvent")
    public String addEvent (ModelMap model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "event-create";
    }
    @PostMapping("/addEvent")
    public String addEvent(@Valid @ModelAttribute("event") EventDTO eventDTO, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("event", eventDTO);
            return "event-create";
        }
        eventService.createEvent(eventDTO);
        return "redirect:/info";
    }
}

