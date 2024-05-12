package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

}
