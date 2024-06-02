package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.UserDTO;

import java.util.List;
import java.util.Set;

public interface UserService {

    void createUser(String username, String password, String firstName, String lastName, String email, boolean enabled, Set<Long> roleIds);
    List<UserDTO> getAllUsers();
    List<UserDTO> getAllUsersWithApartments();
}
