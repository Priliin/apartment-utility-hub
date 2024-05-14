package com.utilityhub.apartmentutilityhub.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private long id;
    private String title;
    private String eventType;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T' HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T' HH:mm")
    private LocalDateTime endTime;
    private LocalDateTime creationDate;
}
