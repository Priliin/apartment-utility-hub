package com.utilityhub.apartmentutilityhub.model;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.yearmonthconverter.YearMonthAttributeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentDataMapper.mapToApartmentDataDTO;

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


