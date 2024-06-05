package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.model.User;

import java.util.Set;

public interface UserService {

    User createUser(String username, String password, String firstName, String lastName, String email, boolean enabled, Set<Long> roleIds);

    UserDTO findUserById(Long userId);

    UserDTO findByUsername(String username);
}
