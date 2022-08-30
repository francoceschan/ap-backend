package com.ap.backend.web;

import com.ap.backend.dao.ExperienciaDao;
import com.ap.backend.dao.ProyectoDao;
import com.ap.backend.exceptions.ResourceNotFoundException;
import com.ap.backend.model.Experiencia;
import com.ap.backend.model.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectoController {

    @Autowired
    private ProyectoDao proyectoDao;

    @GetMapping("/proyecto")
    public List<Proyecto> listarProyectos() {return  proyectoDao.findAll();}

    @PostMapping("/proyecto/guardar")
    public  Proyecto guardarProyecto(@RequestBody Proyecto proyecto){
        return proyectoDao.save(proyecto);
    }

    @GetMapping("/proyecto/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id){
        Proyecto proyecto = proyectoDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el proyecto con el ID: "+id));
        return ResponseEntity.ok(proyecto);
    }

    @PutMapping("/proyecto/{id}")
    public ResponseEntity<Proyecto> modificarProyecto(@PathVariable Long id, @RequestBody Proyecto datosProyecto){
        Proyecto proyecto = proyectoDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el proyecto con el ID: "+id));

        proyecto.setNombre(datosProyecto.getNombre());
        proyecto.setDescripcion(datosProyecto.getDescripcion());
        proyecto.setLink(datosProyecto.getLink());


        Proyecto proyectoActualizado = proyectoDao.save(proyecto);
        return ResponseEntity.ok(proyectoActualizado);
    }

    @DeleteMapping("/proyecto/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProyecto(@PathVariable Long id){
        Proyecto proyecto = proyectoDao.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No existe el proyecto con el ID: "+id));
        proyectoDao.delete(proyecto);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}









