package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentRepo extends JpaRepository<Apartment, Long> {

    Optional<ApartmentDTO> findApartmentByApartmentNumber(Integer apartmentNumber);


    @Query("SELECT a FROM Apartment a WHERE a.ownersLastName LIKE CONCAT ('%', :query, '%')")
    List<Apartment> searchByOwnersLastName(String query);
}