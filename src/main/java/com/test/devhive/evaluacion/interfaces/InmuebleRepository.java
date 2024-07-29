package com.test.devhive.evaluacion.interfaces;

import com.test.devhive.evaluacion.models.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
