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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<UserDTO> findAll() {
        List<User> users = new ArrayList<>(userRepo.findAll());
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user: users){
            UserDTO userDTO = mapToUserDTO(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }
}
