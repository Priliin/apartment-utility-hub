package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;

public class ApartmentDataMapper {

    public static ApartmentData mapToApartmentData(ApartmentDataDTO apartmentDataDTO) {
        return ApartmentData.builder()
                .dataId(apartmentDataDTO.getDataId())
                .date(apartmentDataDTO.getDate())
                .hotWaterUsage(apartmentDataDTO.getHotWaterUsage())
                .coldWaterUsage(apartmentDataDTO.getColdWaterUsage())
                .gasUsage(apartmentDataDTO.getGasUsage())
                .apartmentId(apartmentDataDTO.getApartmentId())
                .build();
    }

    public static ApartmentDataDTO mapToApartmentDataDTO(ApartmentData apartmentData) {
        return ApartmentDataDTO.builder()
                .dataId(apartmentData.getDataId())
                .date(apartmentData.getDate())
                .hotWaterUsage(apartmentData.getHotWaterUsage())
                .coldWaterUsage(apartmentData.getColdWaterUsage())
                .gasUsage(apartmentData.getGasUsage())
                .apartmentId(apartmentData.getApartmentId())
                .build();
    }
}
