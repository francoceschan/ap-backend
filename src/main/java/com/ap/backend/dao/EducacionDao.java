package com.ap.backend.dao;

import com.ap.backend.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionDao extends JpaRepository<Educacion, Long> {
}
