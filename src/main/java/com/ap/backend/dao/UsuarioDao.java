package com.ap.backend.dao;

import com.ap.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
