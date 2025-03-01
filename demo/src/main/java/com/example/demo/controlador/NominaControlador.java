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
import com.example.demo.modelo.nomina;
import com.example.demo.repositorio.empleado_repositorio;
import com.example.demo.repositorio.nomina_repositorio;

@RestController
@RequestMapping("/ver/nomi")

public class NominaControlador {

	@Autowired
	private nomina_repositorio repositorio;
	
	@Autowired
	private empleado_repositorio repositorio2;
	
	@GetMapping ("/nomina")
	public List<nomina> verNominas(){
		return repositorio.findAll();
	}
	
	
	
	
	@GetMapping ("/eliminar")
	public List<nomina> eliminarNom(){
		this.repositorio.deleteById((long)2);
		return this.repositorio.findAll();
		}

	  @GetMapping("/buscarporDeducidos")
	    public List <nomina> buscarPordeducidos(){
		  
	        return repositorio.findByDeducidos(5000);
	    }

	
	    

	    @GetMapping("/buscaringresos")
	    public List <nomina> buscarPoringresos(){
		  
	        return repositorio.findByingresos(5000);
	    }
	    @GetMapping("/buscarsalario")
	    public List <nomina> buscarPorsalario(){
		  
	        return repositorio.findBySalario(5000);
	    }
	    
	    @GetMapping("/buscartotalsalario")
	    public List <nomina> buscarTotalsalario(){
		  
	        return repositorio.findByTotalsalario(1553560);
	    }
	    
	    @GetMapping("/buscaridentificacion")
	    public List <nomina> buscarIdentificacion(){
		  
	        return repositorio.findById(25221054);
	    }
	    @GetMapping("/guardarrr")
	    public List <nomina>guardarEmpleado(
	    
	 
	    @RequestParam Float salario,
	    @RequestParam Float deducidos,
	    @RequestParam Float ingresos,
	    @RequestParam Float totalsalario,
	    @RequestParam String fechae,
	    @RequestParam empleado empleados)
	     throws ParseException {
	    	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
	    	Date fecha=sdf.parse(fechae);
	        Float salud = salario * 0.04f;
	        Float pension = salario * 0.06f;
	        Float bonificacion = salario < (2 * 1000000) ? salario * 0.1f : 0;
	        Float totalSalario = ingresos - deducidos - salud - pension + bonificacion;
	    	
	    	nomina e = new nomina(salario,deducidos,ingresos,totalsalario,fecha,empleados);
	    	this.repositorio.save(e);
	    	return this.repositorio.findAll();
	    }
	    
	
	    @GetMapping("/total-nomina")
	    public List<Object[]> obtenerTotalNominaPorAño(@RequestParam(name = "año") int año) {  
	        return repositorio.obtenerTotalNominaPorAño(año);
	    }
	
	    @GetMapping("/totalmes")
		public List<Object> totalmes(){
			
			return this.repositorio.totalMonth();
			
		}
		@GetMapping("/cantidadem")
		public List<Object> cantidadem(){
			
			return this.repositorio.cantidadE();
		
	}
		@GetMapping("/cupagos")
		public List<Object> cuantospagos(){
			
			return this.repositorio.cuantosPa();
		
	}
		@GetMapping("/sueldomayor")
		public List<Object> sueldomayor(){
			
			return this.repositorio.mayorSueldo();
		
	}
		
		
		
		
		@GetMapping("/mespromedio")
		public List<Object> mesprom(){
			
			return this.repositorio.promedioMes();
		
}
		
		
}
	
	
	
	
	
	
	
	
	
