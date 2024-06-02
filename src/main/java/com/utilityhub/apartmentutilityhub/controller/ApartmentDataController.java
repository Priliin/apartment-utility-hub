package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
    addApartmentData: POST päring kommunaalnäitude andmete lisamiseks.
    getApartmentDataByApartmentId: GET päring kommunaalnäitude andmete saamiseks korteri ID järgi.
    updateApartmentData: PUT päring kommunaalnäitude andmete uuendamiseks.
    deleteApartmentData: DELETE päring kommunaalnäitude andmete kustutamiseks.
*/

@Controller
@RequestMapping("/api/apartmentdata")
public class ApartmentDataController {

    private final ApartmentDataService apartmentDataService;

    @Autowired
    public ApartmentDataController(ApartmentDataService apartmentDataService) {
        this.apartmentDataService = apartmentDataService;
    }

    @GetMapping("/all")
    public String getAllApartmentData(ModelMap modelMap) {
        List<ApartmentDataDTO> apartmentData = apartmentDataService.findAllApartments();
        modelMap.addAttribute("apartments", apartmentData);
        return "utility-view";
    }

    @GetMapping("/addWater")
    public String addApartmentDataWater(@Valid @ModelAttribute("apartmentData")
                                   ApartmentDTO apartmentDTO,
                                        BindingResult result,
                                        ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("apartmentData", apartmentDTO);
            return "utility-water-usage-create";
        }
//        apartmentDataService.saveApartmentData(apartmentData); // TODO: Save function needs to be fixed
        return "redirect:/api/apartmentdata";
    }

    @GetMapping("/addGas")
    public String addApartmentData(@Valid @ModelAttribute("apartmentData")
                                   ApartmentDTO apartmentDTO,
                                   BindingResult result,
                                   ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("apartmentData", apartmentDTO);
            return "utility-gas-usage-create";
        }
//        apartmentDataService.saveApartmentData(apartmentData); // TODO: Save function needs to be fixed
        return "redirect:/api/apartmentdata";
    }


    @PostMapping
    public ResponseEntity<ApartmentData> addApartmentDataWater(@RequestBody ApartmentData apartmentData) {
        ApartmentData newApartmentData = apartmentDataService.addApartmentData(apartmentData);
        return new ResponseEntity<>(newApartmentData, HttpStatus.CREATED);
    }

    @GetMapping("/{apartmentId}")
    public ResponseEntity<List<ApartmentData>> getApartmentDataByApartmentId(@PathVariable Apartment id) {
        List<ApartmentData> apartmentDataList = apartmentDataService.getApartmentDataByApartmentId(id.getId());
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
