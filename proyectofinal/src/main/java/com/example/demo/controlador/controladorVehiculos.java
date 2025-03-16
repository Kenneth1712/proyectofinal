package com.example.demo.controlador;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.modeloVehiculos;
import com.example.demo.repositorio.repositorioVehiculo;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin(origins = "http://localhost:4200") //
public class controladorVehiculos {

    @Autowired
    private repositorioVehiculo repositorio;

    @GetMapping("/buscarDisponibles")
    public List<modeloVehiculos> Disponibles(@RequestParam("tipo") String tipo) {
        return repositorio.findByEstadoAndTipo("disponible", tipo);
    }
    
}