package com.utilityhub.apartmentutilityhub.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    // Welcome page
    // http://localhost:8080/auth/welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Apartment Utility Hub homepage! " +
                "\nThe page will open soon!";
    }

/*   // Endpoint available for user role
   // http://localhost:8080/auth/user/userProfile
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    // Endpoint available for admin role
    // http://localhost:8080/auth/admin/adminProfile
    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }*/



    // Endpoint for the propertyOwner role
    // http://localhost:8080/aunipith/user/userProfile
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_PROPERTY OWNER')")
    public String propertyOwnerProfile() {
        return "Welcome, property owner!";
    }

    // Endpoint for the accountant role
    // http://localhost:8080/auth/accountant/accountantProfile
    @GetMapping("/accountant/accountantProfile")
    @PreAuthorize("hasAuthority('ROLE_ACCOUNTANT')")
    public String accountantProfile() {
        return "Welcome, accountant!";
    }

    // Endpoint for the admin role
    // http://localhost:8080/auth/admin/adminProfile
    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public  String adminProfile() {
        return "Welcome back, admin!";
    }
}



