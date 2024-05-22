package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;

import java.util.List;

public interface ApartmentDataService {

    ApartmentData addApartmentData(ApartmentData apartmentData);

    List<ApartmentData> getApartmentDataByApartmentId(Apartment apartmentId);

    ApartmentData updateApartmentData(Long apartmentId, ApartmentData apartmentData);

    void deleteApartmentData(Long apartmentId);
}
