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
import static com.utilityhub.apartmentutilityhub.mapper.ApartmentDataMapper.mapToApartmentDataDTO;

@Service
public class ApartmentDataServiceImpl implements ApartmentDataService {

    private final ApartmentDataRepo apartmentDataRepo;


    @Autowired
    public ApartmentDataServiceImpl(ApartmentDataRepo apartmentDataRepo) {
        this.apartmentDataRepo = apartmentDataRepo;
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
