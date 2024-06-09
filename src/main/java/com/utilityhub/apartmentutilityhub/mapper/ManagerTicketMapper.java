    package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ManagerTicketDTO;
import com.utilityhub.apartmentutilityhub.model.ManagerTicket;

public class ManagerTicketMapper {

    public static ManagerTicket mapToManagerTicket(ManagerTicketDTO managerTicketDTO){
        return ManagerTicket.builder()
                .id(managerTicketDTO.getId())
                .title(managerTicketDTO.getTitle())
                .description(managerTicketDTO.getDescription())
                .creationDate(managerTicketDTO.getCreationDate())
                .build();
    }

    public static ManagerTicketDTO mapToManagerTicketDTO(ManagerTicket managerTicket){
        return ManagerTicketDTO.builder()
                .id(managerTicket.getId())
                .title(managerTicket.getTitle())
                .description(managerTicket.getDescription())
                .creationDate(managerTicket.getCreationDate())
                .build();
    }
}
