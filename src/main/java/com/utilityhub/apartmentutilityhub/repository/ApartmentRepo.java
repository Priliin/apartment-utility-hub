package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentRepo extends JpaRepository<Apartment, Long> {

    Optional<Apartment> findApartmentByApartmentNumber(Integer apartmentNumber);
}
