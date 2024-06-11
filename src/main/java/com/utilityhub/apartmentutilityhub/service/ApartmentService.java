package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApartmentService {
    List<ApartmentDTO> findAllApartments();

    Apartment saveApartment(ApartmentDTO apartmentDTO);


    List<ApartmentDTO> searchApartmentByOwnersLastName(String query);
    ApartmentDTO findApartmentByApartmentNumber(Integer apartmentNumber);

    void userIdToApartment(Integer apartmentNumber, Long userID);

}