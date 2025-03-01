package com.example.demo.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.empleado;
import com.example.demo.repositorio.empleado_repositorio;

@RestController
@RequestMapping("/ver/e1")
public class EmpleadoControlador {
	
	
	@Autowired
	private empleado_repositorio repositorio;
	
	@GetMapping ("/empleado")
	public List<empleado> verTodoEmpleados(){
		return repositorio.findAll();
	}
	
	@GetMapping ("/guardar")
	public List<empleado> guardarEm(){
		empleado em = new empleado ((long)25221432, "juan", "camilo","juan@gmail.com");
		this.repositorio.save(em);
		return this.repositorio.findAll();
	}
	
	@GetMapping ("/buscar")
	public empleado buscarE(){
		
		return this.repositorio.findById((long)25221431).orElse(null);
	}
	
	@GetMapping ("/eliminar")
	public List<empleado> eliminarEm(){
		this.repositorio.deleteById((long)1007247665);
		return this.repositorio.findAll();
		}
	
	@GetMapping("/actualizar")
	public List<empleado> actualizar(){
		empleado emp= this.repositorio.findById((long)25221431).get();
		System.out.println(emp);
		emp.setApellidos("herrera");
		this.repositorio.save(emp);
		return this.repositorio.findAll();
	
	}
	
	  @GetMapping("/buscarPorEmail")
	    public empleado buscarPorEmail(){
		  
	        return this.repositorio.findByEmail("kenneth@gmail.com");
	    }

	  @GetMapping("/buscarporNombre")
	    public List <empleado> buscarPorNombre(){
		  
	        return this.repositorio.findByNombre("alejandro");
	    }
	  @GetMapping("/buscarporApellidos")
	    public List < empleado> buscarPorApellidos(){
		  
	        return this.repositorio. findByApellidos("herrera");
	    } 
	    
	    @GetMapping("/buscarempleadonomina")
	    public List<Object>buscarnom(){
	    	return this.repositorio.buscarNominaE(25221431L);
	    }
	    
	    
	    
}