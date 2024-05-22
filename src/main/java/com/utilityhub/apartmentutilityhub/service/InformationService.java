package com.utilityhub.apartmentutilityhub.service;

import com.utilityhub.apartmentutilityhub.dto.InformationDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InformationService {

    List<InformationDTO> findAllInformation();
    void createInfo(InformationDTO informationDTO);

    InformationDTO findById(Long id);
    List<InformationDTO> searchByTitle(String query);
}
