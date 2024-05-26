package com.utilityhub.apartmentutilityhub.model;

import com.utilityhub.apartmentutilityhub.yearmonthconverter.YearMonthAttributeConverter;
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
    @Column(nullable = false, updatable = false)
    private Long dataId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false) // Viitab 'apartmentId' veerule tabelis 'apartments'

    private Long dataId;
    private Apartment apartment;
    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth yearMonth;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
}
