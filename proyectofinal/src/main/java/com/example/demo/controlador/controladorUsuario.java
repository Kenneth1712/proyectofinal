package com.example.demo.controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.demo.repositorio.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.modeloUsuario;
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200") //
public class controladorUsuario {
	
    @Autowired
    private repositorioUsuario repositorio;
    
    @PostMapping("/guardarU")
    public ResponseEntity<?> guardarUsuario(
            @RequestParam Long idUsuario,
            @RequestParam String nombre,
            @RequestParam String fechaExpedicion,
            @RequestParam String vigencia,
            @RequestParam String correoElectronico,
            @RequestParam Long numeroTel,
            @RequestParam String categoria,
            @RequestParam String password
            ) throws ParseException {

        // Verificar si el usuario ya está registrado por ID
    	  if (repositorio.existsById(idUsuario)) {
    	        return ResponseEntity.badRequest().body(Map.of("mensaje", "El usuario con ID " + idUsuario + " ya está registrado."));
    	    }

        // Convertir la fecha de String a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaExpedicionDate = formato.parse(fechaExpedicion);

        // Crear objeto usuario
        modeloUsuario usuario = new modeloUsuario(idUsuario, nombre, fechaExpedicionDate, categoria, correoElectronico, vigencia, password, numeroTel, null);

        repositorio.save(usuario);
        // Guardar usuario en la base de datos
        return ResponseEntity.ok(Map.of("mensaje", "Registrado exitosamente"));
    }


    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam Long idUsuario, @RequestParam String password) {
    	
    	System.out.print(idUsuario + password);
        List<modeloUsuario> usuarios = repositorio.findAll();

        for (modeloUsuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario) && usuario.getPassword().equals(password)) {
                return ResponseEntity.ok(Map.of("mensaje", "Bienvenido " + usuario.getNombre()));
            }
        }

        return ResponseEntity.badRequest().body(Map.of("mensaje", "Error: usuario o contraseña incorrectos"));
    }
}
	