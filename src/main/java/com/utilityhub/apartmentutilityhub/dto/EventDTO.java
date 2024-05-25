package com.utilityhub.apartmentutilityhub.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

// Data Transfer Object (DTO) class for creating new events (meetings etc).
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private long id;
    @NotEmpty(message = "Enter the title of the event!")
    private String title;
    @NotEmpty(message = "Fill in the description of the event!")
    private String eventDescription;
    @NotEmpty(message = "Enter the type of the event!")
    private String eventType;
    @NotNull(message = "Set the starting time of the event!")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime startTime;
    @NotNull(message = "Set the ending time of the event!")
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime endTime;
    @NotEmpty(message = "Fill in the content of the event!")
    private String eventContent;
    private LocalDateTime creationDate;
}
