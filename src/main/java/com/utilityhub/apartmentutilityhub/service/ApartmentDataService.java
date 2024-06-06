package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;

import java.util.List;

public interface ApartmentDataService {


    Apartment saveApartmentData(ApartmentDataDTO apartmentDataDTO);

    ApartmentDataDTO findByDataId(Long apartmentId);

    ApartmentData createApartmentData(Double hotWaterUsage, Double coldWaterUsage, Double gasUsage);
}
