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
    private final ApartmentRepo apartmentRepo;


    @Autowired
    public ApartmentDataServiceImpl(ApartmentDataRepo apartmentDataRepo, ApartmentRepo apartmentRepo) {
        this.apartmentDataRepo = apartmentDataRepo;
        this.apartmentRepo = apartmentRepo;
    }

    @Override
    public ApartmentData createApartmentData(Double hotWaterUsage, Double coldWaterUsage, Double gasUsage, Long apartmentId) {
        ApartmentData data = new ApartmentData();
        data.setHotWaterUsage(hotWaterUsage);
        data.setColdWaterUsage(coldWaterUsage);
        data.setGasUsage(gasUsage);

        apartmentDataRepo.save(data);

        return data;
    }

    @Override
    public void apartmentIdToData(Integer apartmentNumber, Long dataId) {
        ApartmentDTO apartment = apartmentRepo.findApartmentByApartmentNumber(apartmentNumber)
                .orElseThrow(() -> new RuntimeException("Apartment number not found"));

        ApartmentData apartmentData = apartmentDataRepo.findById(dataId)
                .orElseThrow(() -> new RuntimeException("data not found"));

        apartmentData.setApartmentId(apartment.getId());
        apartmentDataRepo.save(apartmentData);

    }

    @Override
    public ApartmentData findByApartmentId(Long apartmentId) {

        return mapToApartmentData(apartmentDataRepo.findByApartmentId(apartmentId));
    }

    @Override
    public List<ApartmentData> findAll() {
        List<ApartmentData> allUtils = apartmentDataRepo.findAll();
        return allUtils;
    }

    @Override
    public void saveData(ApartmentData apartmentData) {
        apartmentDataRepo.save(apartmentData);
    }

}
