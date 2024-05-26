package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Resource is the endpoint, interaction with the user
@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentServiceImpl apartmentService;

    public ApartmentController(ApartmentServiceImpl apartmentService) {
        this.apartmentService = apartmentService;
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
        apartmentDTO.setApartmentId(apartment.getApartmentId());
        apartmentService.saveApartment(apartmentDTO);
        return "redirect:/apartment/{apartmentNumber}";
    }


    // Delete apartment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable("id") Long id) {
        apartmentService.deleteApartmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
