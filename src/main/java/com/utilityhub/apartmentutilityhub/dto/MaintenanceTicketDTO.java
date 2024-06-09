package com.utilityhub.apartmentutilityhub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceTicketDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
}
