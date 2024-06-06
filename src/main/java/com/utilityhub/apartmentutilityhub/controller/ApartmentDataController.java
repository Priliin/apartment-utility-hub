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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                        ,apartmentDataDTO.getGasUsage(), apartmentDataDTO.getApartmentId());

        ApartmentDTO apartment = apartmentService.findApartmentByApartmentNumber(apartmentNumber);
        apartmentDataService.apartmentIdToData(apartment.getApartmentNumber(), apartmentData.getDataId());
        apartmentDataService.saveData(apartmentData);

        return "redirect:/apartment/myApartments";
    }

    @GetMapping("/viewUtilities/{apartmentNumber}")
    public String getApartmentData(@PathVariable() int apartmentNumber, ModelMap modelMap) {
        List<ApartmentData> allUtilities = apartmentDataService.findAll();
        List<ApartmentData> utilities = new ArrayList<>();
        ApartmentDTO apartmentDTO = apartmentService.findApartmentByApartmentNumber(apartmentNumber);

        for(ApartmentData data:allUtilities){
            if(Objects.equals(data.getApartmentId(), apartmentDTO.getId())){
                utilities.add(data);
            }
        }

        modelMap.addAttribute("apartmentData", utilities);
        return "utility-view";
    }
}
