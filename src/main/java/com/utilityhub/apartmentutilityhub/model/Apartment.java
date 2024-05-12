package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Apartment {

    // Create a table to the database
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private int apartmentNumber;

    private String ownersFirstName;
    private String ownersLastName;
    private String ownersPhone;
    private String ownersEmail;

}
