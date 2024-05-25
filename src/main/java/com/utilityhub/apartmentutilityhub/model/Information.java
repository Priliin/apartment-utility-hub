package com.utilityhub.apartmentutilityhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

// Entity that creates and represents a record of information in a database
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String infoTitle;
    @Column(name = "info_content", length = 16777215, columnDefinition = "mediumtext")
    private String infoContent;
    private String infoDescription;
    @CreationTimestamp
    private LocalDateTime creationDate;

}



