package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// This interface interacts with Information entities in the database.
@Repository
public interface InformationRepo extends JpaRepository<Information, Long> {
    // Method to find an Information entity by its ID.
    Optional<Information> findById(Long id);

    // Query is used to find Information entities
    // where the infoTitle field contains the text provided in the query parameter.
    @Query("SELECT i FROM Information i WHERE i.infoTitle LIKE CONCAT ('%', :query, '%')")
    List<Information> findByTitle(String query);

}
