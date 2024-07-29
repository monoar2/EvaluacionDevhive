package com.test.devhive.evaluacion.controllers;
import com.test.devhive.evaluacion.interfaces.InmuebleRepository;
import com.test.devhive.evaluacion.models.Inmueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inmuebles")
public class InmuebleController {

    private final InmuebleRepository inmuebleRepository;

    @Autowired
    public InmuebleController(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @GetMapping
    public List<Inmueble> obtenerInmuebles() {
        return inmuebleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Inmueble obtenerInmueble(@PathVariable Long id) {
        return inmuebleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Inmueble crearInmueble(@RequestBody Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    @PutMapping("/{id}")
    public Inmueble actualizarInmueble(@PathVariable Long id, @RequestBody Inmueble inmuebleActualizado) {
        Inmueble inmuebleExistente = inmuebleRepository.findById(id).orElse(null);
        if (inmuebleExistente != null) {
            inmuebleExistente.setNombre(inmuebleActualizado.getNombre());
            inmuebleExistente.setDireccion(inmuebleActualizado.getDireccion());
            inmuebleExistente.setTelefono(inmuebleActualizado.getTelefono());
            inmuebleExistente.setCapacidadAforo(inmuebleActualizado.getCapacidadAforo());
            return inmuebleRepository.save(inmuebleExistente);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarInmueble(@PathVariable Long id) {
        inmuebleRepository.deleteById(id);
    }
}