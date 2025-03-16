package com.example.demo.controlador;

import com.example.demo.modelo.modeloAlquiler;
import com.example.demo.modelo.modeloVehiculos;
import com.example.demo.repositorio.repositorioAlquiler;
import com.example.demo.repositorio.repositorioVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.modeloAlquiler;
import com.example.demo.modelo.modeloUsuario;
import com.example.demo.modelo.modeloVehiculos;
import com.example.demo.repositorio.repositorioAlquiler;
import com.example.demo.repositorio.repositorioUsuario;
import com.example.demo.repositorio.repositorioVehiculo;

@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200")
public class controladorAlquiler {
    
    @Autowired
    private repositorioAlquiler repositorio;
    @Autowired
    private repositorioVehiculo repositorioVehiculo;
    @Autowired
    private repositorioUsuario repositorioUsuario;
    
    @GetMapping("/buscarNoEntregados")
    public List<Object> buscarNoEntregados() {
        List<Object> vehiculosNo = new LinkedList<>();
        List<modeloAlquiler> alquileres = this.repositorio.findAll();
        String estadoAl = "no entregado";
        
        for (modeloAlquiler alquiler : alquileres) {
            if (alquiler.getEstadoAlquiler().equals(estadoAl)) {
                vehiculosNo.add("Placa: " + alquiler.getVehiculo().getIdVehiculo());
                vehiculosNo.add("Nombre: " + alquiler.getUsuario().getNombre());
                vehiculosNo.add("Cédula: " + alquiler.getUsuario().getIdUsuario());
                return vehiculosNo;
            }    
        }
        return vehiculosNo;
    }
    
    @GetMapping("/actualizar")
    public List<Object> actualizar(@RequestParam String placa) {
        List<Object> resultado = new LinkedList<>();
        List<modeloAlquiler> alquileres = this.repositorio.findAll();

        for (modeloAlquiler alquiler : alquileres) {
            if (alquiler.getVehiculo().getIdVehiculo().equals(placa)) {
                alquiler.setEstadoAlquiler("entregado");
                this.repositorio.save(alquiler);
                return resultado;
            } else {
                resultado.add("No se encontraron vehículos relacionados con la placa: " + placa);
            }
        }
        return resultado;
    }
    
    @GetMapping("/cancelarAlqui")
    public List<Object> cancelar(@RequestParam Long idAlquiler) {
        List<Object> resultado = new LinkedList<>();
        Optional<modeloAlquiler> alquilerOpt = this.repositorio.findById(idAlquiler);
        
        if (alquilerOpt.isPresent()) {
            modeloAlquiler alquiler = alquilerOpt.get();
            alquiler.getVehiculo().setEstado("disponible");
            this.repositorio.save(alquiler);
            this.repositorio.deleteById(idAlquiler);
        } else {
            resultado.add("No se encontró ningún alquiler con esta referencia " + idAlquiler);
        }
        return resultado;
    }
    
    @GetMapping("/todos")
    public List<modeloAlquiler> obtenerTodosLosAlquileres() {
        return this.repositorio.findAll();
    }
    
    @GetMapping("/buscaralqui")
    public List<modeloAlquiler> buscarAlquiler(@RequestParam Long idUsuario) {
        return this.repositorio.findByUsuario_IdUsuario(idUsuario);
    }
    
    @PostMapping("/solicitar")
    public ResponseEntity<?> solicitarAlquiler(
            @RequestParam Long idUsuario,
            @RequestParam Long idVehiculo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {

        Optional<modeloUsuario> usuarioOpt = repositorioUsuario.findById(idUsuario);
        Optional<modeloVehiculos> vehiculoOpt = repositorioVehiculo.findById(idVehiculo);

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("El usuario no existe.");
        }

        if (vehiculoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("El vehículo no existe.");
        }

        modeloVehiculos vehiculo = vehiculoOpt.get();
        if (!"disponible".equalsIgnoreCase(vehiculo.getEstado())) {
            return ResponseEntity.badRequest().body("El vehículo no está disponible para alquiler.");
        }

        modeloAlquiler nuevoAlquiler = new modeloAlquiler();
        nuevoAlquiler.setUsuario(usuarioOpt.get());
        nuevoAlquiler.setVehiculo(vehiculo);
        nuevoAlquiler.setFechaInicio(fechaInicio);
        nuevoAlquiler.setFechaFin(fechaFin);
        nuevoAlquiler.setEstadoAlquiler("pendiente de entrega");

        // Establecer actividadAlquiler para evitar el valor null
        nuevoAlquiler.setActividadAlquiler("Solicitud de alquiler registrada");

        modeloAlquiler alquilerGuardado = repositorio.save(nuevoAlquiler);
        vehiculo.setEstado("no disponible");
        repositorioVehiculo.save(vehiculo);
        return ResponseEntity.ok(alquilerGuardado);
    }
}


