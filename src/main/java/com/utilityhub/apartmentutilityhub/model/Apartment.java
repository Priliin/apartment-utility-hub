package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// Entity class that creates and represents an apartment entity in a database.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private Integer apartmentNumber;
    private String ownersFirstName;
    private String ownersLastName;
    private String ownersPhone;
    private String ownersEmail;
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.REMOVE)
    private List<ApartmentData> apartmentDataList = new ArrayList<>();

}
