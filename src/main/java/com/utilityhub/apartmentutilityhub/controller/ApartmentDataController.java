package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
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
    private final ApartmentServiceImpl apartmentService;

    @Autowired
    public ApartmentDataController(ApartmentDataService apartmentDataService, ApartmentServiceImpl apartmentService) {
        this.apartmentDataService = apartmentDataService;
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{apartmentNumber}")
    public String getApartmentData(@PathVariable() int apartmentNumber, ModelMap modelMap) {
       ApartmentDTO apartmentDTO = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
       ApartmentDataDTO apartmentDataDTO = apartmentDataService.findByApartmentId(apartmentDTO.getId());

        modelMap.addAttribute("apartment", apartmentDataDTO);
        return "utility-view-2";
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
}
