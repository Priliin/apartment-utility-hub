package com.utilityhub.apartmentutilityhub.security.controller;


import com.utilityhub.apartmentutilityhub.model.ApartmentData;
import com.utilityhub.apartmentutilityhub.repository.ApartmentDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.YearMonth;
import java.util.Objects;

@Controller
public class ApartmentDataController {

    private final ApartmentDataRepo apartmentDataRepo;

    @Autowired
    public ApartmentDataController(ApartmentDataRepo apartmentDataRepo) {
        this.apartmentDataRepo = apartmentDataRepo;
    }

    @PostMapping("/addApartmentData")
    public String addApartmentData(Long apartmentId, Integer year, Integer month, Double hotWaterUsage, Double coldWaterUsage, Double gasUsage) {

        // Loome uue ApartmentData objekti
        ApartmentData apartmentData = new ApartmentData();

        // Seame aasta ja kuu YearMonth objektiks
        YearMonth yearMonth = YearMonth.of(year, month);
        apartmentData.setYearMonth(yearMonth);

        // Seame muud andmed
        apartmentData.setApartment(Objects.requireNonNull(apartmentDataRepo.findById(apartmentId).orElse(null)).getApartment());
        apartmentData.setHotWaterUsage(hotWaterUsage);
        apartmentData.setColdWaterUsage(coldWaterUsage);
        apartmentData.setGasUsage(gasUsage);

        // Salvestame ApartmentData andmebaasi
        apartmentDataRepo.save(apartmentData);

        // Suuname kasutaja korterite lehele
        return "redirect:/apartments";
    }
}

