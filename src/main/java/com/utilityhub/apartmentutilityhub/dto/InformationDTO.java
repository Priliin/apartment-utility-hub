package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationDTO {

    private long id;
    @NotEmpty(message = "Enter the title!")
    private String infoTitle;
    @NotEmpty(message = "Fill in the content for information page")
    private String infoContent;
    @NotEmpty(message = "Fill in a short description")
    private String infoDescription;
    private LocalDateTime creationDate;
}
