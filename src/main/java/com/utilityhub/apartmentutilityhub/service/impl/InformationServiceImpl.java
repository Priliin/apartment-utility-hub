package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.InformationDTO;
import com.utilityhub.apartmentutilityhub.model.Event;
import com.utilityhub.apartmentutilityhub.model.Information;
import com.utilityhub.apartmentutilityhub.repository.InformationRepo;
import com.utilityhub.apartmentutilityhub.service.InformationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.EventMapper.mapToEventDTO;
import static com.utilityhub.apartmentutilityhub.mapper.InformationMapper.mapToInformation;
import static com.utilityhub.apartmentutilityhub.mapper.InformationMapper.mapToInformationDTO;

@Service
@Transactional
public class InformationServiceImpl implements InformationService {

    private InformationRepo informationRepo;

    // Constructor that uses dependency injection
    // to inject an instance of InformationRepo.
    public InformationServiceImpl(InformationRepo informationRepo) {
        this.informationRepo = informationRepo;
    }

    // Method to find all information entries from the database
    @Override
    public List<InformationDTO> findAllInformation() {
        List<Information> informationList = informationRepo.findAll();
        return informationList.stream().map(information -> mapToInformationDTO(information)).collect(Collectors.toList());
    }

    // Method to create a new information entry
    @Override
    public void createInfo(InformationDTO informationDTO) {
        Information information = mapToInformation(informationDTO);
        informationRepo.save(information);
    }

    // Method to find an information entry by its ID
    @Override
    public InformationDTO findById(Long id) {
        Information information = informationRepo.findById(id).get();
        return mapToInformationDTO(information);
    }

    // Method to perform a search based on the title of the Information entities.
    @Override
    public List<InformationDTO> searchByTitle(String query) {
        List<Information> informationByTitle= informationRepo.findByTitle(query);
        return informationByTitle.stream().map(information -> mapToInformationDTO(information)).collect(Collectors.toList());
    }

}

