package com.example.demo.repositorio;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.nomina;

public interface nomina_repositorio extends JpaRepository<nomina, Long>{
public List<nomina>findByDeducidos(long deducidos);
public List<nomina>findByFecha(Date fecha);
public List<nomina>findByingresos(long ingresos);
public List <nomina>findBySalario(long salario);
public List<nomina>findByTotalsalario(long totalsalario);
List <nomina>findById(long identifacion);

	

@Query("SELECT MONTH(n.fecha) AS mes, SUM(n.totalsalario) AS total " +
       "FROM nomina n " +
       "WHERE YEAR(n.fecha) = :año " +
       "GROUP BY MONTH(n.fecha)")
List<Object[]> obtenerTotalNominaPorAño(@Param("año") int año);



	@Query(value = "SELECT SUM(n.salario) " +
          "FROM nomina n " +
          "WHERE EXTRACT(MONTH FROM n.fecha) GROUP BY n.fecha ORDER BY n.fecha ", 
  nativeQuery = true)
	 public List<Object> totalMonth();
	
	
	//Contador personas
	@Query(value = "SELECT COUNT(*) as empleados " +
          "FROM empleados ", nativeQuery = true)
	 public List<Object> cantidadE();
	
	//Pagos recibidos cada empleado
	@Query(value = "SELECT e.nombre, COUNT(n.salario) as empleados " +
          "FROM nomina n inner join empleados e ON e.identificacion = n.identificacion "
          + " GROUP BY e.identificacion ", nativeQuery = true)
	 public List<Object> cuantosPa();
	
	//Nombre empleado mayor sueldo
	@Query(value = "SELECT e.nombre, max(n.salario) " +
          "FROM nomina n inner join empleados e ON e.identificacion = n.identificacion "
          + "GROUP BY e.nombre", nativeQuery = true)
	 public List<Object> mayorSueldo();
	
	
	
	//Promedio nomina mes
	@Query(value = "SELECT EXTRACT(MONTH FROM n.fecha) as mes, AVG(n.salario) " +
          "FROM nomina n " +
          " GROUP BY mes", nativeQuery = true)
	 public List<Object> promedioMes();
	

}

	