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
@Table(name = "apartment_data")
public class ApartmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false) // Viitab 'apartmentId' veerule tabelis 'apartments'
    private Apartment apartment;

    private YearMonth yearMonth;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}
