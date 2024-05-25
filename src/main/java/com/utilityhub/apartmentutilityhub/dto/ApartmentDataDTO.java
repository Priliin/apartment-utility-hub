package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;

// Data Transfer Object (DTO) class for storing apartment data
// For entering the hot and cold water usage
// TODO: How to add graphics of the usages? L.
@Data
public class ApartmentDataDTO {

    @NotNull(message = "Apartment ID must not be null")
    private Long apartmentId;
    @NotNull(message = "Month must not be null")
    private YearMonth month;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}
