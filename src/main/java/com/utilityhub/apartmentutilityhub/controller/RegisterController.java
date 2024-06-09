package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.repository.ApartmentRepo;
import com.utilityhub.apartmentutilityhub.repository.RoleRepo;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
import com.utilityhub.apartmentutilityhub.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import static com.utilityhub.apartmentutilityhub.mapper.ApartmentMapper.mapToApartment;


@Controller
public class RegisterController {


    private final UserServiceImpl userService;
    private final RoleRepo roleRepo;
    private final ApartmentRepo apartmentRepo;
    private final ApartmentServiceImpl apartmentService;

    public RegisterController(UserServiceImpl userService, RoleRepo roleRepo, ApartmentRepo apartmentRepo, ApartmentServiceImpl apartmentService) {
        this.userService = userService;
        this.roleRepo = roleRepo;
        this.apartmentRepo = apartmentRepo;
        this.apartmentService = apartmentService;
    }

    @GetMapping("/register")
    public String registerForm(ModelMap model) {

        UserDTO userDTO = new UserDTO();

        model.addAttribute("user", userDTO);
        model.addAttribute("allRoles", roleRepo.findAll());
        model.addAttribute("apartmentNumber", apartmentRepo.findAll());

        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute UserDTO userDTO) {
        userService.createUser(userDTO.getUsername(), userDTO.getPassword() , userDTO.getFirstName(),
                userDTO.getLastName(), userDTO.getEmail(),userDTO.isEnabled(), userDTO.getRoles());


        return "redirect:/home";
    }

    @GetMapping("register/apartmentList")

    public String apartmentList(ModelMap model) {

        List<ApartmentDTO> apartmentDTO = apartmentService.findAllApartments();

        model.addAttribute("apartments", apartmentDTO);
        return "register-apartmentList";
    }
    @GetMapping("/register/userToApartment/{apartmentNumber}")
    public String userToApartment(@PathVariable("apartmentNumber") Integer apartmentNumber, ModelMap model){
        List<UserDTO> findAllUsers = userService.findAll();
        ApartmentDTO apartmentDTO = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        Apartment apartment = mapToApartment(apartmentDTO);
        UserDTO user = new UserDTO();

        model.addAttribute("user", user);
        model.addAttribute("apartment", apartment);
        model.addAttribute("users", findAllUsers);


    return "userToApartment";
    }

    @PostMapping("/register/userToApartment/{apartmentNumber}")
    public String addUser(@ModelAttribute("apartment") Apartment apartment, @ModelAttribute("user") UserDTO userDTO){
        UserDTO user = userService.findUserById(userDTO.getId());

        apartmentService.userIdToApartment(apartment.getApartmentNumber(), user.getId());

        return "redirect:/register/apartmentList";
    }
}