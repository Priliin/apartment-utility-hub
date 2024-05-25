package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.InformationDTO;
import com.utilityhub.apartmentutilityhub.model.Information;

// mapping between two types of objects:
// Information and InformationDTO
public class InformationMapper {

    public static Information mapToInformation(InformationDTO informationDTO){
        return Information.builder()
                .id(informationDTO.getId())
                .infoTitle(informationDTO.getInfoTitle())
                .infoContent(informationDTO.getInfoContent())
                .infoDescription(informationDTO.getInfoDescription())
                .creationDate(informationDTO.getCreationDate())
                .build();
    }

    public static InformationDTO mapToInformationDTO(Information information){
        return InformationDTO.builder()
                .id(information.getId())
                .infoTitle(information.getInfoTitle())
                .infoContent(information.getInfoContent())
                .infoDescription(information.getInfoDescription())
                .creationDate(information.getCreationDate())
                .build();
    }
}
