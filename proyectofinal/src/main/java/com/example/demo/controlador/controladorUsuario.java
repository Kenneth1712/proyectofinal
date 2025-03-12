package com.example.demo.controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.demo.repositorio.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:4200")
public class controladorUsuario {
	
    @Autowired
    private repositorioUsuario repositorio;
    
    @PostMapping("/guardarU")
    public String guardarUsuario(
            @RequestParam Long idUsuario,
            @RequestParam String nombre,
            @RequestParam String fechaExpedicion,
            @RequestParam String categoria,
            @RequestParam String correoElectronico,
            @RequestParam String vigencia,
            @RequestParam String password,
            @RequestParam Long numeroTel) throws ParseException {

        // Verificar si el usuario ya está registrado por ID
        if (repositorio.existsById(idUsuario)) {
            return "El usuario con ID " + idUsuario + " ya está registrado.";
        }

        // Convertir la fecha de String a Date
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaExpedicionDate = formato.parse(fechaExpedicion);

        // Crear objeto usuario
        modeloUsuario usuario = new modeloUsuario(idUsuario, nombre, fechaExpedicionDate, categoria, correoElectronico, vigencia, password, numeroTel, null);

        // Guardar usuario en la base de datos
        repositorio.save(usuario);
        
        return "Usuario registrado exitosamente.";
    }


    @PostMapping("/login")
    public String login(@RequestParam Long idUsuario, @RequestParam String password) {
        List<modeloUsuario> usuarios = this.repositorio.findAll();
        for (modeloUsuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario) && usuario.getPassword().equals(password)) {
                return "Bienvenido " + usuario.getNombre();
            }
        }
        return "Error: usuario o contraseña incorrectos";
    }
}

	