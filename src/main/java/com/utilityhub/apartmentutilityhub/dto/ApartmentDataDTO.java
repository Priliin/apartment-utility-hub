    package com.utilityhub.apartmentutilityhub.dto;

    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.time.LocalDate;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApartmentDataDTO {


        private Long dataId;
        @DateTimeFormat(pattern = "MM.YYYY")
        private LocalDate date;
        @NotNull(message = "Enter the hot water gauge reading!")
        private Double hotWaterUsage;
        @NotNull(message = "Enter the cold water gauge reading!")
        private Double coldWaterUsage;
        @NotNull(message = "Enter the gas gauge reading!")
        private Double gasUsage;
        private Long apartmentId;
    }