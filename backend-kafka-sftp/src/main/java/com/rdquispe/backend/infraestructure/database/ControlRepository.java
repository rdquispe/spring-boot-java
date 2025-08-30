package com.rdquispe.backend.infraestructure.database;

import com.rdquispe.backend.domain.Control;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControlRepository extends JpaRepository<Control, String> {

}
