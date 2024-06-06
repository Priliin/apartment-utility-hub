package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.ApartmentDTO;
import com.utilityhub.apartmentutilityhub.dto.ApartmentDataDTO;
import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.service.ApartmentDataService;
import com.utilityhub.apartmentutilityhub.service.impl.ApartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.utilityhub.apartmentutilityhub.mapper.ApartmentDataMapper.mapToApartmentData;
import static com.utilityhub.apartmentutilityhub.mapper.ApartmentDataMapper.mapToApartmentDataDTO;


@Controller
@RequestMapping("/api/apartmentData")
public class ApartmentDataController {

    private final ApartmentDataService apartmentDataService;
    private final ApartmentServiceImpl apartmentService;

    @Autowired
    public ApartmentDataController(ApartmentDataService apartmentDataService, ApartmentServiceImpl apartmentService) {
        this.apartmentDataService = apartmentDataService;
        this.apartmentService = apartmentService;
    }


    @GetMapping("/add/{apartmentNumber}")
    public String addDataForm(@PathVariable("apartmentNumber") Integer apartmentNumber,
                               ModelMap model){

        ApartmentData apartmentData = new ApartmentData();
        Integer number = apartmentService.findApartmentByApartmentNumber(apartmentNumber).getApartmentNumber();

        model.addAttribute("apartmentData", apartmentData);
        model.addAttribute("apartmentNumber", number);
        return "usage-create";

    }

    @PostMapping("/add/{apartmentNumber}")
    public String addData(@Valid @ModelAttribute
                          ApartmentDataDTO apartmentDataDTO,
                          BindingResult result,
                          @PathVariable("apartmentNumber") Integer apartmentNumber, ModelMap model){

        if (result.hasErrors()) {
            model.addAttribute("apartmentData", apartmentDataDTO);
            return "usage-create";
        }
        ApartmentData apartmentData = apartmentDataService
                .createApartmentData(apartmentDataDTO.getHotWaterUsage()
                        ,apartmentDataDTO.getColdWaterUsage()
                        ,apartmentDataDTO.getGasUsage());

        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        apartmentService.dataIdToApartment(apartment.getApartmentNumber(), apartmentData.getDataId());
        return "redirect:/apartment/myApartments";
    }

    @GetMapping("/viewUtilities/{apartmentNumber}")
    public String getApartmentData(@PathVariable() int apartmentNumber, ModelMap modelMap) {
       ApartmentDTO apartmentDTO = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        ApartmentDataDTO apartmentDataDTO = apartmentDataService.findByDataId(apartmentDTO.getDataId());

        modelMap.addAttribute("apartmentData", apartmentDataDTO);
        return "utility-view";
    }
}
