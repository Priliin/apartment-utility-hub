package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.repository.RoleRepo;
import com.utilityhub.apartmentutilityhub.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/register")
    public String registerForm(ModelMap model) {

        UserDTO userDTO = new UserDTO();

        model.addAttribute("user", userDTO);
        model.addAttribute("allRoles", roleRepo.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute UserDTO userDTO) {
        userService.createUser(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(),
                userDTO.getLastName(), userDTO.getEmail(),userDTO.isEnabled(), userDTO.getRoles());
        return "redirect:/home";
    }
}