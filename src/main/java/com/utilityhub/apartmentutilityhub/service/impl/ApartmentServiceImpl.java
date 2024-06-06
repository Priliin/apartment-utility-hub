package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.exception.UserNotFoundException;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.model.User;
import com.utilityhub.apartmentutilityhub.repository.ApartmentDataRepo;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import com.utilityhub.apartmentutilityhub.repository.UserRepo;
import com.utilityhub.apartmentutilityhub.service.ApartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartment;
import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartmentDTO;


@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepo apartmentRepo;
    private final UserRepo userRepo;
    private final ApartmentDataRepo apartmentDataRepo;

    public ApartmentServiceImpl(ApartmentRepo apartmentRepo, UserRepo userRepo, ApartmentDataRepo apartmentDataRepo) {
        this.apartmentRepo = apartmentRepo;
        this.userRepo = userRepo;
        this.apartmentDataRepo = apartmentDataRepo;
    }


    @Override
    public List<ApartmentDTO> findAllApartments() {
        List<Apartment> apartments = apartmentRepo.findAll();
        return apartments.stream().map((apartment) -> mapToApartmentDTO(apartment)).collect(Collectors.toList());

    }

    @Override
    public Apartment saveApartment(ApartmentDTO apartmentDTO) {
        Apartment apartment = mapToApartment(apartmentDTO);
        return apartmentRepo.save(apartment);
    }

    @Override
    public List<ApartmentDTO> searchApartmentByOwnersLastName(String query) {
        List<Apartment> apartments = apartmentRepo.searchByOwnersLastName(query);
        return apartments.stream().map(apartment -> mapToApartmentDTO(apartment)).collect(Collectors.toList());

    }

    // Find apartment by Apartment Number
    @Override
    public ApartmentDTO findApartmentByApartmentNumber(Integer apartmentNumber) {
        return apartmentRepo.findApartmentByApartmentNumber(apartmentNumber).orElseThrow(
                () -> new RuntimeException("Apartment number " + apartmentNumber + " not found!")
        );
    }

    @Override
    public void userIdToApartment(Integer apartmentNumber, Long userID) {
        ApartmentDTO apartment = apartmentRepo.findApartmentByApartmentNumber(apartmentNumber)
                .orElseThrow(() -> new RuntimeException("Apartment number not found!"));

        User user = userRepo.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));

        apartment.setUserId(user.getId());

        Apartment apartmentDTO = mapToApartment(apartment);

        apartmentRepo.save(apartmentDTO);


    }

    @Override
    public void dataIdToApartment(Integer apartmentNumber, Long dataId) {
        ApartmentDTO apartmentDTO = apartmentRepo.findApartmentByApartmentNumber(apartmentNumber)
                .orElseThrow(() -> new RuntimeException("Apartment not found"));

        ApartmentData data = apartmentDataRepo.findById(dataId)
                .orElseThrow(() -> new RuntimeException("Data by ID not found"));

        apartmentDTO.setDataId(data.getDataId());
        Apartment apartment = mapToApartment(apartmentDTO);
        apartmentRepo.save(apartment);

    }
}
