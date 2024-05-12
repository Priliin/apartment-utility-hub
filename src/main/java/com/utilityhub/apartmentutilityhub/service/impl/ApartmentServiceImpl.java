package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.exception.UserNotFoundException;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartmentDTO;


@Service
@Transactional
public class ApartmentServiceImpl {

    private final ApartmentRepo apartmentRepo;

    public ApartmentServiceImpl(ApartmentRepo apartmentRepo) {
        this.apartmentRepo = apartmentRepo;
    }

    // Adding new apartment
    public Apartment addApartment(Apartment apartment) {
        apartment.setId(apartment.getId()+1); // ? Set id
        return apartmentRepo.save(apartment);
    }

    // Find all apartments
    public List<ApartmentDTO> findAllApartments() {
       List<Apartment> apartments = apartmentRepo.findAll();
       return apartments.stream().map((apartment) -> mapToApartmentDTO(apartment)).collect(Collectors.toList());

    }

    // Update apartment information
    public Apartment updateApartment(Apartment apartment) {
        return apartmentRepo.save(apartment);
    }

    // Find apartment by Apartment Number
    public Apartment findApartmentByApartmentNumber(Integer apartmentNumber) {
        return apartmentRepo.findApartmentByApartmentNumber(apartmentNumber).orElseThrow(
                () -> new UserNotFoundException("Apartment number " + apartmentNumber + " not found!")
        );
    }

    // Delete apartment by ID
    public void deleteApartmentById(Integer id) {
        apartmentRepo.deleteById(id);
    }

}
