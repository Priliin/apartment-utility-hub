package com.utilityhub.apartmentutilityhub.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotEmpty(message = "Enter username!")
    private String username;
    @NotEmpty(message = "Enter password!")
    private String password;
    @NotEmpty(message = "Enter email!")
    private String email;
    @NotEmpty(message = "Enter first name!")
    private String firstName;
    @NotEmpty(message = "Enter last name!")
    private String lastName;
    private boolean enabled;

    private Set<Long> roles;

}
