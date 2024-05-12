package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;

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
