package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.ManagerTicketDTO;
import com.utilityhub.apartmentutilityhub.mapper.ManagerTicketMapper;
import com.utilityhub.apartmentutilityhub.model.ManagerTicket;
import com.utilityhub.apartmentutilityhub.repository.ManagerTicketRepository;
import com.utilityhub.apartmentutilityhub.service.ManagerTicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerTicketServiceImpl implements ManagerTicketService {

    private final ManagerTicketRepository managerTicketRepository;

    public ManagerTicketServiceImpl(ManagerTicketRepository managerTicketRepository) {
        this.managerTicketRepository = managerTicketRepository;
    }

    @Override
    public void save(ManagerTicketDTO managerTicketDTO) {
        ManagerTicket managerTicket = ManagerTicketMapper.mapToManagerTicket(managerTicketDTO);
        managerTicketRepository.save(managerTicket);
    }

    @Override
    public List<ManagerTicketDTO> findAll() {
        List<ManagerTicket> managerTickets = managerTicketRepository.findAll();
        return managerTickets.stream()
                .map(this::mapToManagerTicketDTO)
                .collect(Collectors.toList());
    }

    // Method to map ManagerTicket to ManagerTicketDTO
    private ManagerTicketDTO mapToManagerTicketDTO(ManagerTicket managerTicket) {
        ManagerTicketDTO dto = ManagerTicketMapper.mapToManagerTicketDTO(managerTicket);
        dto.setCreationDate(processCreationDate(managerTicket.getCreationDate()));
        return dto;
    }

    // Method to process creation date from ManagerTicket, retaining day accuracy
    private LocalDateTime processCreationDate(LocalDateTime creationDateFromDB) {
        // Truncate the time part to retain only the date
        return creationDateFromDB.truncatedTo(ChronoUnit.DAYS);
    }
}
