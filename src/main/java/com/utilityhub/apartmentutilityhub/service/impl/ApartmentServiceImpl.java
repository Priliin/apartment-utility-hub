package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper;
import com.utilityhub.apartmentutilityhub.model.Apartment;
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


@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepo apartmentRepo;
    private final UserRepo userRepo;

    public ApartmentServiceImpl(ApartmentRepo apartmentRepo, UserRepo userRepo, ApartmentDataRepo apartmentDataRepo) {
        this.apartmentRepo = apartmentRepo;
        this.userRepo = userRepo;
    }


    @Override
    public List<ApartmentDTO> findAllApartments() {
        List<Apartment> apartments = apartmentRepo.findAll();
        return apartments.stream().map(ApartmentMapper::mapToApartmentDTO).collect(Collectors.toList());

    }

    @Override
    public Apartment saveApartment(ApartmentDTO apartmentDTO) {
        Apartment apartment = mapToApartment(apartmentDTO);
        return apartmentRepo.save(apartment);
    }

    @Override
    public List<ApartmentDTO> searchApartmentByOwnersLastName(String query) {
        List<Apartment> apartments = apartmentRepo.searchByOwnersLastName(query);
        return apartments.stream().map(ApartmentMapper::mapToApartmentDTO).collect(Collectors.toList());

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
}
