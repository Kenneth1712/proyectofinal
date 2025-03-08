package com.example.demo.controlador;
import java.text.ParseException;
import com.example.demo.repositorio.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.modeloUsuario;
@RestController
@RequestMapping("/usuario")
public class controladorUsuario {

    @Autowired
    private repositorioUsuario repositorio;
    
    @PostMapping("/registrar")
    public String registrar(@RequestBody modeloUsuario nuevoUsuario) {
        if (repositorio.existsById(nuevoUsuario.getIdUsuario())) {
            return "Error: el usuario ya existe";
        }
        repositorio.save(nuevoUsuario);
        return "Usuario registrado exitosamente";
    }



    @GetMapping("/login")
    public String login(@RequestParam Long idUsuario, @RequestParam String contraseña) {
        List<modeloUsuario> usuarios = this.repositorio.findAll();
        for (modeloUsuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario) && usuario.getContraseña().equals(contraseña)) {
                return "Bienvenido " + usuario.getNombre();
            }
        }
        return "Error: usuario o contraseña incorrectos";
    }
}

	