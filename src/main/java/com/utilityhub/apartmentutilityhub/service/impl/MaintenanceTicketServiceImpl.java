package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.MaintenanceTicketDTO;
import com.utilityhub.apartmentutilityhub.mapper.MaintenanceTicketMapper;
import com.utilityhub.apartmentutilityhub.model.MaintenanceTicket;
import com.utilityhub.apartmentutilityhub.repository.MaintenanceTicketRepository;
import com.utilityhub.apartmentutilityhub.service.MaintenanceTicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceTicketServiceImpl implements MaintenanceTicketService {

    private final MaintenanceTicketRepository maintenanceTicketRepository;

    public MaintenanceTicketServiceImpl(MaintenanceTicketRepository maintenanceTicketRepository) {
        this.maintenanceTicketRepository = maintenanceTicketRepository;
    }

    @Override
    public void save(MaintenanceTicketDTO maintenanceTicketDTO) {
        MaintenanceTicket maintenanceTicket = MaintenanceTicketMapper.mapToMaintenanceTicket(maintenanceTicketDTO);
        maintenanceTicketRepository.save(maintenanceTicket);
    }

    @Override
    public List<MaintenanceTicketDTO> findAll() {
        List<MaintenanceTicket> maintenanceTickets = maintenanceTicketRepository.findAll();
        return maintenanceTickets.stream()
                .map(this::mapToMaintenanceTicketDTO)
                .collect(Collectors.toList());
    }

    // Method to map MaintenanceTicket to MaintenanceTicketDTO
    private MaintenanceTicketDTO mapToMaintenanceTicketDTO(MaintenanceTicket maintenanceTicket) {
        MaintenanceTicketDTO dto = MaintenanceTicketMapper.mapToMaintenanceTicketDTO(maintenanceTicket);
        dto.setCreationDate(processCreationDate(maintenanceTicket.getCreationDate()));
        return dto;
    }

    // Method to process creation date from MaintenanceTicket, retaining day accuracy
    private LocalDateTime processCreationDate(LocalDateTime creationDateFromDB) {
        // Truncate the time part to retain only the date
        return creationDateFromDB.truncatedTo(ChronoUnit.DAYS);
    }
}
