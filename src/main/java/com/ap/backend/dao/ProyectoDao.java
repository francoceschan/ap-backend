package com.ap.backend.dao;

import com.ap.backend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoDao extends JpaRepository<Proyecto,Long> {
}
