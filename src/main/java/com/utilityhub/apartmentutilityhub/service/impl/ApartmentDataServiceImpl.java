package com.utilityhub.apartmentutilityhub.service.impl;


import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.repository.ApartmentDataRepo;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentDataMapper.mapToApartmentData;

@Service
public class ApartmentDataServiceImpl implements ApartmentDataService {

    private ApartmentDataRepo apartmentDataRepo;
    private ApartmentRepo apartmentRepository;

    @Autowired
    public ApartmentDataServiceImpl(ApartmentRepo apartmentRepository, ApartmentDataRepo apartmentDataRepo) {
        this.apartmentRepository = apartmentRepository;
        this.apartmentDataRepo = apartmentDataRepo;
    }


    private ApartmentDataDTO mapToApartmentDataDTO(ApartmentData apartmentData) {
        return ApartmentDataDTO.builder()
                .hotWaterUsage(apartmentData.getHotWaterUsage())
                .coldWaterUsage(apartmentData.getColdWaterUsage())
                .date(apartmentData.getDate())
                .build();
    }


    @Override
    public Apartment saveApartmentData(ApartmentDataDTO apartmentDataDTO) {
        return null;
    }

    @Override
    public ApartmentDataDTO findByDataId(Long dataId) {
        ApartmentData apartmentData = apartmentDataRepo.findById(dataId)
                .orElseThrow(() -> new RuntimeException("Apartment number not found"));

        return mapToApartmentDataDTO(apartmentData);
    }

    @Override
    public ApartmentData createApartmentData(Double hotWaterUsage, Double coldWaterUsage, Double gasUsage) {
        ApartmentData data = new ApartmentData();
        data.setHotWaterUsage(hotWaterUsage);
        data.setColdWaterUsage(coldWaterUsage);
        data.setGasUsage(gasUsage);

        apartmentDataRepo.save(data);

        return data;
    }

}
