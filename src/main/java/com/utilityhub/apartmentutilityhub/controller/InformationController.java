package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.InformationDTO;
import com.utilityhub.apartmentutilityhub.model.Information;
import com.utilityhub.apartmentutilityhub.service.impl.InformationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/information")
public class InformationController {

    private final InformationServiceImpl informationService;

    public InformationController(InformationServiceImpl informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/{id}")
    public String infoDetails(@PathVariable("id") Long id, ModelMap model) {
        InformationDTO information = informationService.findById(id);
        model.addAttribute("information", information);
        return "information-details";
    }

    @GetMapping()
    public String getInfoPage(ModelMap model){
        List<InformationDTO> information = informationService.findAllInformation();
        model.addAttribute("information", information);
        return "general-information";
    }

    @GetMapping("/addInfo")
    public String addInfo (ModelMap model){
        Information information = new Information();
        model.addAttribute("information", information);
        return "information-create";
    }
    @PostMapping("/addInfo")
    public String addInfo (@Valid @ModelAttribute("information") InformationDTO informationDTO, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            model.addAttribute("information", informationDTO);
            return "information-create";
        }
        informationService.createInfo(informationDTO);
        return "redirect:/information";
    }
    @GetMapping("/search")
    public String searchInfo(@RequestParam(value = "query") String query, ModelMap model) {
        List<InformationDTO> infoByTitle = informationService.searchByTitle(query);
        model.addAttribute("information", infoByTitle);
        return "general-information";
    }
}
