package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApartmentService {
    // Method to retrieve a list of all apartments,
    // transforming them into ApartmentDTO objects before returning.
    List<ApartmentDTO> findAllApartments();

    // Method to save an apartment’s data, which is passed as an ApartmentDTO.
    Apartment saveApartment(ApartmentDTO apartmentDTO);

    // Method to find and return an apartment entity based on the apartment ID.
    Apartment findByApartmentId(long apartmentId);

    // Method to delete an apartment from the database
    void deleteApartment(Long apartmentId);

    // Method to search for apartments based on the owner’s last name
    List<ApartmentDTO> searchApartmentByOwnersLastName(String query);

    // Method to find and return an ApartmentDTO based on the apartment number
    ApartmentDTO findApartmentByApartmentNumber(Integer apartmentNumber);

}
