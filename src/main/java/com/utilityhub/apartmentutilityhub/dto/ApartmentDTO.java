package com.utilityhub.apartmentutilityhub.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDTO {

    private Long apartmentId;
    @NotEmpty(message = "Enter the owners first name!")
    private String ownersFirstName;
    @NotEmpty(message = "Enter the owners last name!")
    private String ownersLastName;
    @NotEmpty(message = "Enter the owners phone number!")
    private String ownersPhone;
    @NotEmpty(message = "Enter the owners email address!")
    private String ownersEmail;
    @NotNull(message = "Enter the owners apartment number!")
    private Integer apartmentNumber;
}