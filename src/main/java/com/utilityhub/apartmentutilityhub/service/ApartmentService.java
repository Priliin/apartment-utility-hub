package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.exception.UserNotFoundException;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ApartmentService {

    private final ApartmentRepo apartmentRepo;

    public ApartmentService(ApartmentRepo apartmentRepo) {
        this.apartmentRepo = apartmentRepo;
    }

    // Adding new apartment
    public Apartment addApartment(Apartment apartment) {
      //  apartment.setApartmentId(apartment.getApartmentId()+1); // ? Set id // ID is generated automatically?
        return apartmentRepo.save(apartment);
    }

    // Find all apartments
    public List<Apartment> findAllApartments() {
        return apartmentRepo.findAll();
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
    public void deleteApartmentById(Long apartmentId) {
        apartmentRepo.deleteById(apartmentId);
    }

}
