package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.EventDTO;
import com.utilityhub.apartmentutilityhub.exception.UserNotFoundException;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.Event;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import com.utilityhub.apartmentutilityhub.service.ApartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartment;
import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartmentDTO;

// Service class that adheres to the ApartmentService interface.
@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepo apartmentRepo;

    // Constructor that uses dependency injection to set the apartmentRepo field.
    public ApartmentServiceImpl(ApartmentRepo apartmentRepo) {
        this.apartmentRepo = apartmentRepo;
    }

    // Find all apartments
    @Override
    public List<ApartmentDTO> findAllApartments() {
       List<Apartment> apartments = apartmentRepo.findAll();
       return apartments.stream().map((apartment) -> mapToApartmentDTO(apartment)).collect(Collectors.toList());

    }

    // Save the apartment
    @Override
    public Apartment saveApartment(ApartmentDTO apartmentDTO) {
        Apartment apartment = mapToApartment(apartmentDTO);
        return apartmentRepo.save(apartment);
    }

    // Find the apartment by ID
    @Override
    public Apartment findByApartmentId(long apartmentId) {
        return null;
    }

    // Delete the apartment
    @Override
    public void deleteApartment(Long apartmentId) {

    }

    // Search apartment by owners last name
    @Override
    public List<ApartmentDTO> searchApartmentByOwnersLastName(String query) {
        List<Apartment> apartments = apartmentRepo.searchByOwnersLastName(query);
        return apartments.stream().map(apartment -> mapToApartmentDTO(apartment)).collect(Collectors.toList());

    }

    // Find apartment by Apartment Number
    @Override
    public ApartmentDTO findApartmentByApartmentNumber(Integer apartmentNumber) {
        return apartmentRepo.findApartmentByApartmentNumber(apartmentNumber).orElseThrow(
                () -> new UserNotFoundException("Apartment number " + apartmentNumber + " not found!")
        );
    }

    // Delete apartment by ID
    public void deleteApartmentById(Long id) {
        apartmentRepo.deleteById(id);
    }

}
