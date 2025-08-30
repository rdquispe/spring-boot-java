package com.rdquispe.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * control: Postgres Model
 */
@Data
@Entity
@Table(name = "control")
public class Control {

    @Id
    @Column(unique = true, nullable = false)
    private String name;

    private String checksum;
    private String type;
    private LocalDateTime creationDate;
}
