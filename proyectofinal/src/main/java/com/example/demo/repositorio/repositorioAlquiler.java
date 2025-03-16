package com.example.demo.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.modelo.modeloAlquiler;

public interface repositorioAlquiler extends JpaRepository<modeloAlquiler, Long> {
    
	  // Buscar alquileres por estado
    List<modeloAlquiler> findByEstadoAlquiler(String estadoAlquiler);
    
    // Buscar alquileres por ID de usuario
    List<modeloAlquiler> findByUsuario_IdUsuario(Long idUsuario);

    // Buscar alquileres por ID de vehículo
    List<modeloAlquiler> findByVehiculoIdVehiculo(Long idVehiculo);
    
    // Método para buscar alquileres por ID de usuario desde el servicio
    default List<modeloAlquiler> obtenerAlquileresPorUsuario(Long idUsuario) {
        return findByUsuario_IdUsuario(idUsuario);
    }
}
