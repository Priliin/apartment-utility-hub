package com.utilityhub.apartmentutilityhub.mapper;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;

public class ApartmentDataMapper {

    public static ApartmentData mapToApartmentData(ApartmentDataDTO apartmentDataDTO) {
        return ApartmentData.builder()
                .dataId(apartmentDataDTO.getApartmentDataId())
                .apartment(apartmentDataDTO.getApartmentId())
                .yearMonth(apartmentDataDTO.getMonth())
                .hotWaterUsage(apartmentDataDTO.getHotWaterUsage())
                .coldWaterUsage(apartmentDataDTO.getColdWaterUsage())
                .gasUsage(apartmentDataDTO.getGasUsage())
                .build();
    }

    public static ApartmentDataDTO mapToApartmentDataDTO(ApartmentData apartmentData) {
        return ApartmentDataDTO.builder()
                .apartmentDataId(apartmentData.getDataId())
                .apartmentId(apartmentData.getApartment())
                .month(apartmentData.getYearMonth())
                .hotWaterUsage(apartmentData.getHotWaterUsage())
                .coldWaterUsage(apartmentData.getColdWaterUsage())
                .gasUsage(apartmentData.getGasUsage())
                .build();
    }
}
