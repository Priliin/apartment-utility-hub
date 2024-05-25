package com.utilityhub.apartmentutilityhub.service;


import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    // Method to retrieve a list of all events,
    // transforming them into EventDTO objects before returning.
    List<EventDTO> findAllEvents();

    // Method to find an event by its ID.
    // It returns an EventDTO object that contains the data of the event.
    EventDTO findEventById(Long id);

    // Method to create a new event.
    // It takes an EventDTO object as a parameter,
    // which contains the data for the new event to be created.
    void createEvent(EventDTO eventDTO);

    // Method to search events by their name.
    // It takes a String parameter as a search query and
    // returns a list of matched EventDTO objects.
    List<EventDTO> searchByEventName(String query);
}
