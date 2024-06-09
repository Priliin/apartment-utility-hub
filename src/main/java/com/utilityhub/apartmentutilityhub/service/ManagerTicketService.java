package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ManagerTicketDTO;

import java.util.List;

public interface ManagerTicketService {
    void save(ManagerTicketDTO managerTicketDTO);
    List<ManagerTicketDTO> findAll();
}
