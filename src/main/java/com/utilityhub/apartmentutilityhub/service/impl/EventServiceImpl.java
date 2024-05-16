package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.Event;
import com.utilityhub.apartmentutilityhub.repository.EventRepo;
import com.utilityhub.apartmentutilityhub.service.EventService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartmentDTO;
import static com.utilityhub.apartmentutilityhub.mapper.EventMapper.mapToEvent;
import static com.utilityhub.apartmentutilityhub.mapper.EventMapper.mapToEventDTO;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private EventRepo eventRepo;

    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepo.findAll();
        return events.stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList());
    }

    @Override
    public EventDTO findEventById(Long id) {
       Event event = eventRepo.findById(id).get();
       return mapToEventDTO(event);
    }

    @Override
    public void createEvent(EventDTO eventDTO) {
        Event event = mapToEvent(eventDTO);
        eventRepo.save(event);
    }

    @Override
    public List<EventDTO> searchByEventName(String query) {
        List<Event> events = eventRepo.searchByEventName(query);
        return events.stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList());    }
}
