package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.modeloUsuario;


public interface repositorioUsuario extends JpaRepository<modeloUsuario, Long> {
	public List<modeloUsuario>findByidUsuario(long idUsuario);
}


