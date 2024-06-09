package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
import com.utilityhub.apartmentutilityhub.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.utilityhub.apartmentutilityhub.security.WebSecurityConfig.getUserByUsername;

// Resource is the endpoint, interaction with the user
@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentServiceImpl apartmentService;
    private final UserServiceImpl userService;

    public ApartmentController(ApartmentServiceImpl apartmentService, UserServiceImpl userService) {
        this.apartmentService = apartmentService;
        this.userService = userService;
    }

    @GetMapping("/myApartments")
    public String userApartments( ModelMap model){

        UserDTO user = getUserByUsername(userService);

       List<ApartmentDTO> apartments = apartmentService.findAllApartments();
       List<ApartmentDTO> userApartments = new ArrayList<>();

       for(ApartmentDTO apartment: apartments){
           if(Objects.equals(apartment.getUserId(), user.getId())){
               userApartments.add(apartment);
           }
       }
        model.addAttribute("user", user);
        model.addAttribute("apartments", userApartments);
        return "user-apartment-list";
    }
    @GetMapping("/myApartments/{apartmentNumber}")
    public String UserApartmentDetails(@PathVariable("apartmentNumber") int apartmentNumber, ModelMap model){
        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);

        model.addAttribute("apartment", apartment);
        return "apartment-details";
    }

    //Apartment details
    @GetMapping("/{apartmentNumber}")
    public String apartmentDetails(@PathVariable("apartmentNumber") int apartmentNumber, ModelMap model) {
        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        model.addAttribute("apartment", apartment);
        return "apartment-details";
    }

    // Read all apartments
    @GetMapping("/all")
    public String getAllApartments(ModelMap model) {
        List<ApartmentDTO> apartments = apartmentService.findAllApartments();
        model.addAttribute("apartments", apartments);
        return "apartment-list";
    }


    // Add new apartment
    @GetMapping("/add")
    public String addApartment(ModelMap model) {
        Apartment newApartment = new Apartment();
        model.addAttribute("apartment", newApartment);
        return "apartment-create";
    }

    @PostMapping("/add")
    public String addApartment(@Valid @ModelAttribute("apartment") ApartmentDTO apartmentDTO, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("apartment", apartmentDTO);
            return "apartment-create";
        }
        apartmentService.saveApartment(apartmentDTO);
        return "redirect:/apartment/all";
    }

    //Search
    @GetMapping("/search")
    public String searchApartments(@RequestParam(value = "query") String query, ModelMap model) {
        List<ApartmentDTO> apartmentsByLastName = apartmentService.searchApartmentByOwnersLastName(query);
        model.addAttribute("apartments", apartmentsByLastName);
        return "apartment-list";
    }

    // Update apartment
    @GetMapping("/{apartmentNumber}/edit")
    public String editApartmentInfo(@PathVariable("apartmentNumber") Integer apartmentNumber, ModelMap model) {
        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        model.addAttribute("apartment", apartment);
        return "apartment-edit";
    }

    @PostMapping("/{apartmentNumber}/edit")
    public String editApartment(@PathVariable("apartmentNumber") Integer apartmentNumber,
                                @Valid @ModelAttribute("apartment")
                                ApartmentDTO apartmentDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "apartment-edit";
        }
        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        apartmentDTO.setId(apartment.getId());
        apartmentService.saveApartment(apartmentDTO);
        return "redirect:/apartment/{apartmentNumber}";
    }
}
