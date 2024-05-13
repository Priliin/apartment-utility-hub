package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.YearMonth;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;

    @ManyToOne
    @JoinColumn(name = "apartment_number", nullable = false)
    private Apartment apartment;

    private YearMonth yearMonth;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}