package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
    @CreationTimestamp
    private LocalDate date;
    private Double hotWaterUsage;
    private Double coldWaterUsage;
    private Double gasUsage;
    private Long apartmentId;
}


