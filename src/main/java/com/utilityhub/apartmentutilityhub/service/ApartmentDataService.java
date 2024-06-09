package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.model.ApartmentData;

import java.util.List;

public interface ApartmentDataService {


    ApartmentData createApartmentData(Double hotWaterUsage, Double coldWaterUsage, Double gasUsage, Long apartmentId);

    void apartmentIdToData(Integer apartmentNumber, Long dataId);

    ApartmentData findByApartmentId(Long apartmentId);

    List<ApartmentData> findAll();

    void saveData(ApartmentData apartmentData);
}
