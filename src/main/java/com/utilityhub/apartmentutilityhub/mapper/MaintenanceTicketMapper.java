package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.MaintenanceTicketDTO;
import com.utilityhub.apartmentutilityhub.model.MaintenanceTicket;

public class MaintenanceTicketMapper {

    public static MaintenanceTicket mapToMaintenanceTicket(MaintenanceTicketDTO maintenanceTicketDTO){
        return MaintenanceTicket.builder()
                .id(maintenanceTicketDTO.getId())
                .title(maintenanceTicketDTO.getTitle())
                .description(maintenanceTicketDTO.getDescription())
                .creationDate(maintenanceTicketDTO.getCreationDate())
                .build();
    }

    public static MaintenanceTicketDTO mapToMaintenanceTicketDTO(MaintenanceTicket maintenanceTicket){
        return MaintenanceTicketDTO.builder()
                .id(maintenanceTicket.getId())
                .title(maintenanceTicket.getTitle())
                .description(maintenanceTicket.getDescription())
                .creationDate(maintenanceTicket.getCreationDate())
                .build();
    }
}
