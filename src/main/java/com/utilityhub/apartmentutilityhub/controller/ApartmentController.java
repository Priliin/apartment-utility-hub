package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    // Read all apartments
    @GetMapping("/all")
    public String getAllApartments( ModelMap model) {
        List<ApartmentDTO> apartments = apartmentService.findAllApartments();
        model.addAttribute("apartments", apartments);
        return "apartment-list";
    }

    // Find apartment by Apartment Number
    @GetMapping("/find/{apartmentNumber}")
    public ResponseEntity<Apartment> getApartmentByApartmentNumber(
            @PathVariable("apartmentNumber") Integer apartmentNumber) {
        Apartment apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        return new ResponseEntity<>(apartment, HttpStatus.OK);
    }

    // Add new apartment
    @PostMapping("/add")
    public ResponseEntity<Apartment> addApartment(@RequestBody Apartment apartment) {
        Apartment newApartment = apartmentService.addApartment(apartment);
        return new ResponseEntity<>(newApartment, HttpStatus.CREATED);
    }

    // Update apartment
    @PutMapping("/update")
    public ResponseEntity<Apartment> updateApartment(@RequestBody Apartment apartment) {
        Apartment updatedApartment = apartmentService.updateApartment(apartment);
        return new ResponseEntity<>(updatedApartment, HttpStatus.OK);
    }

    // Delete apartment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        apartmentService.deleteApartmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
