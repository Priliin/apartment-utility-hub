package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Apartment {

    // Create a table to the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long apartmentId;

    @Column(nullable = false, updatable = false)
    private Integer apartmentNumber;

    private String ownersFirstName;
    private String ownersLastName;
    private String ownersPhone;
    private String ownersEmail;

    @OneToMany(mappedBy = "apartment")
    private List<ApartmentData> data;
}

