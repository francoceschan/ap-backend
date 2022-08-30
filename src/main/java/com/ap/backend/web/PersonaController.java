package com.ap.backend.web;

import com.ap.backend.dao.PersonaDao;
import com.ap.backend.exceptions.ResourceNotFoundException;
import com.ap.backend.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    @GetMapping("/persona")
    public ResponseEntity<Persona> obtenerPersonaPorId(){
        Long id = Long.valueOf(1);
        Persona persona = personaDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe la persona con el ID: "+id));
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Long id, @RequestBody Persona datosPersona){
        Persona persona = personaDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe la persona con el ID: "+id));

        persona.setNombre(datosPersona.getNombre());
        persona.setTitulo(datosPersona.getTitulo());

        Persona personaActualizada = personaDao.save(persona);
        return ResponseEntity.ok(personaActualizada);
    }


}
