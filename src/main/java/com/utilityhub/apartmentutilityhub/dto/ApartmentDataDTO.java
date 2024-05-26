    package com.utilityhub.apartmentutilityhub.dto;

    import com.utilityhub.apartmentutilityhub.model.Apartment;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.YearMonth;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApartmentDataDTO {


        @NotNull(message = "Apartment ID must not be null")
        private Apartment id;
        private Long apartmentDataId;
        @NotNull(message = "Month must not be null")
        private YearMonth month;
        private Double hotWaterUsage;
        private Double coldWaterUsage;
        private Double gasUsage;
    }