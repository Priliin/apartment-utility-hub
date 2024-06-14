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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private Integer apartmentNumber;
    private String ownersFirstName;
    private String ownersLastName;
    private String ownersPhone;
    private String ownersEmail;
    private Long userId;


}
