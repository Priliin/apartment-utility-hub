package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepo extends JpaRepository<Apartment, Long> {

    Optional<Apartment> findApartmentByApartmentNumber(Integer apartmentNumber);
}
