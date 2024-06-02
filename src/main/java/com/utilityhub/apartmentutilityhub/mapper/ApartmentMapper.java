package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;

public class ApartmentMapper {

    public static Apartment mapToApartment(ApartmentDTO apartment){
        Apartment apartmentDTO = Apartment.builder()
                .id(apartment.getId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .userId(apartment.getUserId())
                .build();
        return apartmentDTO;
    }
    public static ApartmentDTO mapToApartmentDTO(Apartment apartment){
        ApartmentDTO apartmentDTO = ApartmentDTO.builder()
                .id(apartment.getId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .userId(apartment.getUserId())
                .build();
        return apartmentDTO;

    }
}
