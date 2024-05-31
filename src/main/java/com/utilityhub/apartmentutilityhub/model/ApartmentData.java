package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
    @JoinColumn(name = "id", nullable = false) // Viitab 'apartmentId' veerule tabelis 'apartments'
    private Apartment apartment;
    private LocalDate date;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}
