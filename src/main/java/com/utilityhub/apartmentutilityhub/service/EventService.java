package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<EventDTO> findAllEvents();
    EventDTO findEventById(Long id);

    void createEvent(EventDTO eventDTO);
}
