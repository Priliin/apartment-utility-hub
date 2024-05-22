package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InformationRepo extends JpaRepository<Information, Long> {
    Optional<Information> findById(Long id);
    @Query("SELECT i FROM Information i WHERE i.infoTitle LIKE CONCAT ('%', :query, '%')")
    List<Information> findByTitle(String query);

}
