package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Event;

public class EventMapper {

    public static Event mapToEvent(EventDTO eventDTO){
        return Event.builder()
                .id(eventDTO.getId())
                .title(eventDTO.getTitle())
                .eventType(eventDTO.getEventType())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .creationDate(eventDTO.getCreationDate())
                .build();

    }
    public static EventDTO mapToEventDTO(Event event){
        return EventDTO.builder()
                .id(event.getId())
                .title(event.getTitle())
                .eventType(event.getEventType())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .creationDate(event.getCreationDate())
                .build();

    }
}