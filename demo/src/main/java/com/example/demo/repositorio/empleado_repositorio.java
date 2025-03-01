package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.empleado;

public interface empleado_repositorio extends JpaRepository<empleado, Long>{

	public empleado findByEmail(String email);
	public List <empleado> findByNombre(String nombre);
	public List <empleado> findByApellidos(String apellidos);
	public List < empleado> findByIdentificación (long identificación );
	@Query(value="Select e.nombre,e.apellidos,n.salario from empleados e inner join" 
	+ " nomina n on e.identificacion=n.identificacion and e.identificacion=:idEmpleado",
			nativeQuery=true	)
public List<Object>buscarNominaE(@Param ( "idEmpleado")long idEmpleado)	;
	
}
