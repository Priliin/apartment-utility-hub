    package com.utilityhub.apartmentutilityhub.dto;

    import com.utilityhub.apartmentutilityhub.model.Apartment;
    import jakarta.validation.constraints.NotEmpty;
    import jakarta.validation.constraints.NotNull;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.annotations.CreationTimestamp;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.time.LocalDate;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class ApartmentDataDTO {

        @NotNull(message = "Apartment ID must not be null")
        private Apartment id;
        private Long apartmentDataId;
        @NotNull(message = "Month must not be null")
        @DateTimeFormat(pattern = "MM.YYYY")
        @CreationTimestamp
        private LocalDate date;
        @NotEmpty(message = "Enter the hot water gauge reading!")
        private Double hotWaterUsage;
        @NotEmpty(message = "Enter the cold water gauge reading!")
        private Double coldWaterUsage;
        @NotEmpty(message = "Enter the gas gauge reading!")
        private Double gasUsage;
    }