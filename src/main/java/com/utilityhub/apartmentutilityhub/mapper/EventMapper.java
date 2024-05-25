package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Event;

// Class that contains two static methods
// for converting between two object types: Event and EventDTO.
public class EventMapper {

    public static Event mapToEvent(EventDTO eventDTO){
        return Event.builder()
                .id(eventDTO.getId())
                .title(eventDTO.getTitle())
                .eventType(eventDTO.getEventType())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .creationDate(eventDTO.getCreationDate())
                .eventDescription(eventDTO.getEventDescription())
                .eventContent(eventDTO.getEventContent())
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
                .eventDescription(event.getEventDescription())
                .eventContent(event.getEventContent())
                .build();

    }
}
