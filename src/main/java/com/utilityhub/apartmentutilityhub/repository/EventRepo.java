package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.Apartment;
import com.utilityhub.apartmentutilityhub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Defines an interface EventRepo that serves as a
// repository for managing Event entities in a database.
@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    // Custom method to find an Event by its ID
    Optional<Event> findById(Long id);

    // Method to use the custom query defined above to
    // return a list of Event entities that have titles containing the given query string.
    @Query("SELECT e FROM Event e WHERE e.title LIKE CONCAT ('%', :query, '%')")
    List<Event> searchByEventName(String query);
}
