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

    @Override
    public List<ApartmentDataDTO> findAllApartments() {
        List<ApartmentData> apartmentDataDTO = apartmentDataRepo.findAll();

        return apartmentDataDTO
                .stream()
                .map((apartmentDataDTOList) -> mapToApartmentDataDTO(apartmentDataDTOList))
                .collect(Collectors.toList());
    }

    private ApartmentDataDTO mapToApartmentDataDTO(ApartmentData apartmentData) {
        return ApartmentDataDTO.builder()
                .id(apartmentData.getApartment())
                .hotWaterUsage(apartmentData.getHotWaterUsage())
                .coldWaterUsage(apartmentData.getColdWaterUsage())
                .date(apartmentData.getDate())
                .build();
    }

    public void addApartmentData(Integer id, ApartmentData apartmentData) {
        Optional<ApartmentDTO> apartment = apartmentRepository.findApartmentByApartmentNumber(id);
        if (apartment == null) {
            throw new RuntimeException("No apartment found with id: " + id);
        }
        ApartmentDataDTO apartmentData1 = mapToApartmentDataDTO(apartmentData);
        apartmentData1.setHotWaterUsage(apartmentData.getHotWaterUsage());
    }

    @Override
    public ApartmentData addApartmentData(ApartmentData apartmentData) {
        return null;
    }

    @Override
    public List<ApartmentData> getApartmentDataByApartmentId(Long apartmentId) {
        return List.of();
    }


    @Override
    public ApartmentData updateApartmentData(Long id, ApartmentData apartmentData) {
        // Retrieve the apartment entity from the repository using the provided ID
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Apartment not found with id: " + id));

        // Update the apartment data with the new values
       
        // Repeat this for all fields you want to update

        // Save the updated apartment entity
        apartmentRepository.save(apartment);
        return apartmentData;
    }


    @Override
    public void deleteApartmentData(Long apartmentId) {
    }

    @Override
    public List<ApartmentData> getAllApartmentData() {
        return List.of();
    }

    @Override
    public ApartmentData getApartmentDataById(Long apartmentId, Long dataId) {
        return null;
    }

    @Override
    public Apartment saveApartmentData(ApartmentDataDTO apartmentDataDTO) {
        return null;
    }

    @Override
    public ApartmentDataDTO findByApartmentId(Long apartmentId) {
        ApartmentData apartmentData = apartmentDataRepo.findById(apartmentId)
                .orElseThrow(() -> new RuntimeException("Apartment number not found"));

        return mapToApartmentDataDTO(apartmentData);
    }

}
