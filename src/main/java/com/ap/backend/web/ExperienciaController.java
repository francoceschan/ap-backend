package com.ap.backend.web;

import com.ap.backend.dao.ExperienciaDao;
import com.ap.backend.exceptions.ResourceNotFoundException;
import com.ap.backend.model.Educacion;
import com.ap.backend.model.Experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "https://ap-frontend.web.app/")
public class ExperienciaController {

    @Autowired
    private ExperienciaDao experienciaDao;

    @GetMapping("/experiencia")
    public List<Experiencia> listarExperiencia(){
        return experienciaDao.findAll();
    }

    @PostMapping("/experiencia/guardar")
    public Experiencia guardarExperiencia(@RequestBody Experiencia experiencia){
        return experienciaDao.save(experiencia);
    }


    @GetMapping("/experiencia/{id}")
    public ResponseEntity<Experiencia> obtenerExperienciaPorId(@PathVariable Long id){
        Experiencia experiencia = experienciaDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe la experiencia con el ID: "+id));
        return ResponseEntity.ok(experiencia);
    }


    @PutMapping("/experiencia/{id}")
    public ResponseEntity<Experiencia> modificarExperiencia(@PathVariable Long id, @RequestBody Experiencia datosExperiencia){
        Experiencia experiencia = experienciaDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe la experiencia con el ID: "+id));

        experiencia.setTitulo(datosExperiencia.getTitulo());
        experiencia.setInstitucion(datosExperiencia.getInstitucion());
        experiencia.setFechaInicio(datosExperiencia.getFechaInicio());
        experiencia.setFechaFin(datosExperiencia.getFechaFin());

        Experiencia experienciaActualizada = experienciaDao.save(experiencia);
        return ResponseEntity.ok(experienciaActualizada);
    }


    @DeleteMapping("/experiencia/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarExperiencia(@PathVariable Long id){
        Experiencia experiencia = experienciaDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe la experiencia con el ID: "+id));
        experienciaDao.delete(experiencia);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}



