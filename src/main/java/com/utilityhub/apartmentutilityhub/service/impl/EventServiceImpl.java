package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Event;
import com.utilityhub.apartmentutilityhub.repository.EventRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.EventMapper.mapToEventDTO;

@Service
@Transactional
public class EventServiceImpl implements EventService{

    private EventRepo eventRepo;

    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepo.findAll();
        return events.stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList());
    }
}
