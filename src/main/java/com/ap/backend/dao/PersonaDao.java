package com.ap.backend.dao;

import com.ap.backend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona,Long> {
}
