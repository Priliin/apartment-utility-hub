package com.utilityhub.apartmentutilityhub.service.impl;

import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.model.Role;
import com.utilityhub.apartmentutilityhub.model.User;
import com.utilityhub.apartmentutilityhub.repository.RoleRepo;
import com.utilityhub.apartmentutilityhub.repository.UserRepo;
import com.utilityhub.apartmentutilityhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.utilityhub.apartmentutilityhub.mapper.UserMapper.mapToUserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(String username, String password, String firstName, String lastName,
                              String email, boolean enabled, Set<Long> roleIds) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setEnabled(enabled);

        Set<Role> userRoles = new HashSet<>();

        for(Long roleId: roleIds){
            Role role = roleRepo.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
            userRoles.add(role);
        }
        user.setRoles(userRoles);
        userRepo.save(user);

        return user;
    }

    @Override
    public UserDTO findUserById(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToUserDTO(user);
    }

    @Override
    public UserDTO findByUsername(String username) {

        User user = userRepo.getUserByUsername(username);
        return mapToUserDTO(user);
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsersWithApartments() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(this::convertToUserDTOWithApartments)
                .collect(Collectors.toList());
    }
    private UserDTO convertToUserDTOWithApartments(User user) {
        UserDTO userDTO = new UserDTO();
        // Map user information
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEnabled(user.isEnabled());
        // Map apartment information
        if (!user.getUserApartments().isEmpty()) {
            userDTO.setApartmentNumber(user.getUserApartments().get(0).getApartmentNumber());
        }
        return userDTO;
    }

    private UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .roles(user.getRoles().stream().map(Role::getId).collect(Collectors.toSet()))
                .build();
    }
}
