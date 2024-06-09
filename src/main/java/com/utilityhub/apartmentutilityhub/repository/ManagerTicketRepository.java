package com.utilityhub.apartmentutilityhub.repository;

import com.utilityhub.apartmentutilityhub.model.ManagerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerTicketRepository extends JpaRepository<ManagerTicket, Long> {
    // You can define custom query methods here if needed
}
