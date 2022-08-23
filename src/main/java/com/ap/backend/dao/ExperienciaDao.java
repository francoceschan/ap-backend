package com.ap.backend.dao;

import com.ap.backend.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaDao extends JpaRepository<Experiencia,Long> {
}
