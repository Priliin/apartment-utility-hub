package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.YearMonth;

@Getter
@Setter
@Entity
public class ApartmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    private YearMonth yearMonth;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}