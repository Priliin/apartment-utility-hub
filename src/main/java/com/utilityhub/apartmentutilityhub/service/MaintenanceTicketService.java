package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.MaintenanceTicketDTO;

import java.util.List;

public interface MaintenanceTicketService {
    void save(MaintenanceTicketDTO maintenanceTicketDTO);
    List<MaintenanceTicketDTO> findAll();
}
