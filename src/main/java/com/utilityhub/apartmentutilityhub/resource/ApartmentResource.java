package com.utilityhub.apartmentutilityhub.resource;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Resource is the endpoint, interaction with the user
@RestController
@RequestMapping("/apartment")
public class ApartmentResource {

    private final ApartmentService apartmentService;

    public ApartmentResource(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    // Read all apartments
    @GetMapping("/all")
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> apartments = apartmentService.findAllApartments();
        return new ResponseEntity<>(apartments, HttpStatus.OK);
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
    public ResponseEntity<?> deleteApartment(@PathVariable("id") Long apartmentId) {
        apartmentService.deleteApartmentById(apartmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
