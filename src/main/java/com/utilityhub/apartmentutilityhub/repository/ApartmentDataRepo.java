package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentDataRepo extends JpaRepository<ApartmentData, Long> {
    //List<ApartmentData> findByApartment_ApartmentId(Long apartmentId);
}

