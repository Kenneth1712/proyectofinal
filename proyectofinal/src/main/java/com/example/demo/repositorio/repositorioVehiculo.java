package com.example.demo.repositorio;

import com.example.demo.modelo.modeloAlquiler;
import com.example.demo.modelo.modeloVehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface repositorioVehiculo extends JpaRepository<modeloVehiculos, Long> {

    @Query(value = "SELECT * FROM vehiculo v WHERE v.estado = :estado AND v.tipo = :tipo", nativeQuery = true)
    List<modeloVehiculos> findByEstadoAndTipo(@Param("estado") String estado, @Param("tipo") String tipo);
    
 
}
