package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;

public class ApartmentMapper {

    public static Apartment mapToApartment(ApartmentDTO apartment){
        Apartment apartmentDTO = Apartment.builder()
                .apartmentId(apartment.getApartmentId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .build();
        return apartmentDTO;
    }
    public static ApartmentDTO mapToApartmentDTO(Apartment apartment){
        ApartmentDTO apartmentDTO = ApartmentDTO.builder()
                .apartmentId(apartment.getApartmentId())
                .ownersFirstName(apartment.getOwnersFirstName())
                .ownersLastName(apartment.getOwnersLastName())
                .ownersPhone(apartment.getOwnersPhone())
                .ownersEmail(apartment.getOwnersEmail())
                .apartmentNumber(apartment.getApartmentNumber())
                .build();
        return apartmentDTO;

    }
}
