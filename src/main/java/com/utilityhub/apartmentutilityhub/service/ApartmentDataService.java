package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;

import java.util.List;

public interface ApartmentDataService {

    ApartmentData addApartmentData(ApartmentData apartmentData);

    List<ApartmentData> getApartmentDataByApartmentId(Long apartmentId);

    ApartmentData updateApartmentData(Long apartmentId, ApartmentData apartmentData);

    void deleteApartmentData(Long apartmentId);

    List<ApartmentDataDTO> findAllApartments();

    List<ApartmentData> getAllApartmentData();

    ApartmentData getApartmentDataById(Long apartmentId, Long dataId);

    //
    Apartment saveApartmentData(ApartmentDataDTO apartmentDataDTO);
}
