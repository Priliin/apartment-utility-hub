package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApartmentService {
    List<ApartmentDTO> findAllApartments();

    Apartment saveApartment(ApartmentDTO apartmentDTO);

    Apartment findByApartmentId(long apartmentId);

    void updateApartment(ApartmentDTO apartment);
    void deleteApartment(Long apartmentId);
    List<ApartmentDTO> searchApartmentByOwnersLastName(String query);
}
