package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.InformationDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InformationService {

    // Method to retrieve a list of all information entries,
    // transforming them into InformationDTO objects before returning.
    List<InformationDTO> findAllInformation();

    // Method to create a new information entry.
    void createInfo(InformationDTO informationDTO);

    // Method to find an information entry by its ID.
    InformationDTO findById(Long id);

    // Method to search an information entries based on their title.
    List<InformationDTO> searchByTitle(String query);
}
