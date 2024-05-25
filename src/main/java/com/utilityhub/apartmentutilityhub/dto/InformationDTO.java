package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Data Transfer Object (DTO) class for entering and storing
// information about the apartment and/or the apartment block.
// TODO: I think we should also add
//       person's name and the apartment number who is entering the info.
// TODO: What kind of "info" do we mean to be added here? General? L.
//       I think maybe we should also add separately a page where we can
//       add any problems and repairs regarding to every apartment and the whole building. L.

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
