package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;

public class ApartmentMapper {

    public static Apartment mapToApartment(ApartmentDTO apartment){
        return Apartment.builder()
                .id(apartment.getId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .userId(apartment.getUserId())
                .build();
    }
    public static ApartmentDTO mapToApartmentDTO(Apartment apartment){
        return ApartmentDTO.builder()
                .id(apartment.getId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .userId(apartment.getUserId())
                .build();

    }
}
