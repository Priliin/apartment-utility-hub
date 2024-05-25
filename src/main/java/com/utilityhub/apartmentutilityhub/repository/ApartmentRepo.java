package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Spring Data repository for the Apartment entity
@Repository
public interface ApartmentRepo extends JpaRepository<Apartment, Long> {

    // Defines a custom query method that returns an ApartmentDTO object
    Optional<ApartmentDTO> findApartmentByApartmentNumber(Integer apartmentNumber);


    // Retrieve a list of Apartment entities
    // where the owner’s last name contains the given search string.
    @Query("SELECT a FROM Apartment a WHERE a.ownersLastName LIKE CONCAT ('%', :query, '%')")
    List<Apartment> searchByOwnersLastName(String query);
}
