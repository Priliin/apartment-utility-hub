package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
    addApartmentData: POST päring kommunaalnäitude andmete lisamiseks.
    getApartmentDataByApartmentId: GET päring kommunaalnäitude andmete saamiseks korteri ID järgi.
    updateApartmentData: PUT päring kommunaalnäitude andmete uuendamiseks.
    deleteApartmentData: DELETE päring kommunaalnäitude andmete kustutamiseks.
*/

@RestController
@RequestMapping("/api/apartmentdata")
public class ApartmentDataController {

    private final ApartmentDataService apartmentDataService;

    @Autowired
    public ApartmentDataController(ApartmentDataService apartmentDataService) {
        this.apartmentDataService = apartmentDataService;
    }

    @PostMapping
    public ResponseEntity<ApartmentData> addApartmentData(@RequestBody ApartmentData apartmentData) {
        ApartmentData newApartmentData = apartmentDataService.addApartmentData(apartmentData);
        return new ResponseEntity<>(newApartmentData, HttpStatus.CREATED);
    }

    @GetMapping("/{apartmentId}")
    public ResponseEntity<List<ApartmentData>> getApartmentDataByApartmentId(@PathVariable Apartment id) {
        List<ApartmentData> apartmentDataList = apartmentDataService.getApartmentDataByApartmentId(id);
        return new ResponseEntity<>(apartmentDataList, HttpStatus.OK);
    }

    @PutMapping("/{apartmentId}")
    public ResponseEntity<ApartmentData> updateApartmentData(@PathVariable Long id, @RequestBody ApartmentData apartmentData) {
        ApartmentData updatedApartmentData = apartmentDataService.updateApartmentData(id, apartmentData);
        return new ResponseEntity<>(updatedApartmentData, HttpStatus.OK);
    }

    @DeleteMapping("/{apartmentId}")
    public ResponseEntity<?> deleteApartmentData(@PathVariable Long id) {
        apartmentDataService.deleteApartmentData(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
