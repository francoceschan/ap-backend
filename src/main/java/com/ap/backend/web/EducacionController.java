package com.ap.backend.web;


import com.ap.backend.dao.EducacionDao;
import com.ap.backend.exceptions.ResourceNotFoundException;
import com.ap.backend.model.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EducacionController {

    @Autowired
    private EducacionDao educacionDao;

    @GetMapping("/educacion")
    public List<Educacion> listarEducacion(){
        return educacionDao.findAll();
    }


    @PostMapping("/educacion/guardar")
    public Educacion guardarEducacion(@RequestBody Educacion educacion){
        return educacionDao.save(educacion);
    }


    @GetMapping("/educacion/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable Long id){
        Educacion educacion = educacionDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el estudio con el ID: "+id));
        return ResponseEntity.ok(educacion);
    }


    @PutMapping("/educacion/{id}")
    public ResponseEntity<Educacion> modificarEducacion(@PathVariable Long id, @RequestBody Educacion datosEducacion){
        Educacion educacion = educacionDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el estudio con el ID: "+id));

        educacion.setTitulo(datosEducacion.getTitulo());
        educacion.setInstitucion(datosEducacion.getInstitucion());
        educacion.setAnioInicio(datosEducacion.getAnioInicio());
        educacion.setAnioFin(datosEducacion.getAnioFin());

        Educacion educacioActualizada = educacionDao.save(educacion);
        return ResponseEntity.ok(educacioActualizada);
    }


    @DeleteMapping("/educacion/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEducacion(@PathVariable Long id){
        Educacion educacion = educacionDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el estudio con el ID: "+id));
        educacionDao.delete(educacion);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
