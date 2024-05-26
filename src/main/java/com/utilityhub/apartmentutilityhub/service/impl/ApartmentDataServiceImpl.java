package com.utilityhub.apartmentutilityhub.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;


import java.util.List;

@Service
public class ApartmentDataServiceImpl implements ApartmentDataService {

    @Autowired
    private ApartmentRepo apartmentRepository;


    public ApartmentDataServiceImpl(ApartmentRepo apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public ApartmentData addApartmentData(ApartmentData apartmentData) {
        return null;
    }

    @Override
    public List<ApartmentData> getApartmentDataByApartmentId(Apartment apartmentId) {
        return List.of();
    }

    @Override
    public ApartmentData updateApartmentData(Long id, ApartmentData apartmentData) {
        // Retrieve the apartment entity from the repository using the provided ID
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Apartment not found with id: " + id));

        // Update the apartment data with the new values
        apartment.setApartmentDataList(apartmentData.getApartment().getApartmentDataList());
        // Repeat this for all fields you want to update

        // Save the updated apartment entity
        apartmentRepository.save(apartment);
        return apartmentData;
    }

    @Override
    public void deleteApartmentData(Long apartmentId) {

    }
}
