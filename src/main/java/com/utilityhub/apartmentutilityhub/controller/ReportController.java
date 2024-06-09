package com.utilityhub.apartmentutilityhub.controller;

import com.utilityhub.apartmentutilityhub.dto.MaintenanceTicketDTO;
import com.utilityhub.apartmentutilityhub.dto.ManagerTicketDTO;
import com.utilityhub.apartmentutilityhub.service.MaintenanceTicketService;
import com.utilityhub.apartmentutilityhub.service.ManagerTicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final MaintenanceTicketService maintenanceTicketService;
    private final ManagerTicketService managerTicketService;

    public ReportController(MaintenanceTicketService maintenanceTicketService, ManagerTicketService managerTicketService) {
        this.maintenanceTicketService = maintenanceTicketService;
        this.managerTicketService = managerTicketService;
    }

    @GetMapping("/addMaintenance")
    public String showAddMaintenanceForm(Model model) {
        model.addAttribute("maintenanceTicket", new MaintenanceTicketDTO());
        return "addMaintenanceTicket";
    }

    @PostMapping("/addMaintenance")
    public String addMaintenanceTicket(@ModelAttribute("maintenanceTicket") MaintenanceTicketDTO maintenanceTicketDTO, Model model) {
        maintenanceTicketService.save(maintenanceTicketDTO);
        model.addAttribute("message", "Your ticket was added.");
        return "home";
    }

    @GetMapping("/addManager")
    public String showAddManagerForm(Model model) {
        model.addAttribute("managerTicket", new ManagerTicketDTO());
        return "addManagerTicket";
    }

    @PostMapping("/addManager")
    public String addManagerTicket(@ModelAttribute("managerTicket") ManagerTicketDTO managerTicketDTO, Model model) {
        managerTicketService.save(managerTicketDTO);
        model.addAttribute("message", "Your ticket was added.");
        return "home";
    }

    @GetMapping("/maintenance")
    public String viewMaintenanceTickets(Model model) {
        List<MaintenanceTicketDTO> maintenanceTickets = maintenanceTicketService.findAll();
        model.addAttribute("maintenanceTickets", maintenanceTickets);
        return "viewMaintenanceTickets";
    }

    @GetMapping("/manager")
    public String viewManagerTickets(Model model) {
        List<ManagerTicketDTO> managerTickets = managerTicketService.findAll();
        model.addAttribute("managerTickets", managerTickets);
        return "viewManagerTickets";
    }
}
