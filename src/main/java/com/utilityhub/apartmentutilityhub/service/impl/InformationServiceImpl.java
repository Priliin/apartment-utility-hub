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

    public InformationServiceImpl(InformationRepo informationRepo) {
        this.informationRepo = informationRepo;
    }

    @Override
    public List<InformationDTO> findAllInformation() {
        List<Information> informationList = informationRepo.findAll();
        return informationList.stream().map(information -> mapToInformationDTO(information)).collect(Collectors.toList());
    }

    @Override
    public void createInfo(InformationDTO informationDTO) {
        Information information = mapToInformation(informationDTO);
        informationRepo.save(information);
    }

    @Override
    public InformationDTO findById(Long id) {
        Information information = informationRepo.findById(id).get();
        return mapToInformationDTO(information);
    }

    @Override
    public List<InformationDTO> searchByTitle(String query) {
        List<Information> informationByTitle= informationRepo.findByTitle(query);
        return informationByTitle.stream().map(information -> mapToInformationDTO(information)).collect(Collectors.toList());
    }

}

