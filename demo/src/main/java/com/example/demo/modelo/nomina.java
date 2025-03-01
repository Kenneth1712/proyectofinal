package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "nomina")



public class nomina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long Numero_nomina;
	
	
	
	
	@Column(name= "salario", length = 80,nullable=false)
	private Float salario; 
	
	@Column(name= "deducidos", length = 80,nullable=false)
	private Float deducidos; 
	
	@Column(name= "ingresos", length = 80,nullable=false)
	private Float ingresos; 
	
	@Column(name= "totalsalario", length = 80,nullable=false)
	private Float totalsalario;
	
	@Temporal(TemporalType.DATE) //para determinar si usa horas o fechas o ambas
	//@DateTimeFormat(iso = ISO.DATE) //para guardar solo la fecha
	@DateTimeFormat(pattern = "MM/dd/yyy")//Lo mismo pero se cambia el formato
	@Column(name = "Fecha", nullable = false)
	private Date fecha;
	
	
	
	@ManyToOne()
	@JoinColumn(name="identificacion",referencedColumnName="identificacion")
	private empleado empleados;
	

	public nomina() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}

	public Long getNumero_nomina() {
		return Numero_nomina;
	}

	public nomina( Float salario, Float deducidos, Float ingresos, Float totalsalario, Date fecha,
			empleado empleados) {
		super();
		this.salario = salario;
		this.deducidos = deducidos;
		this.ingresos = ingresos;
		this.totalsalario = totalsalario;
		this.fecha = fecha;
		this.empleados = empleados;
	}


	public void setNumero_nomina(Long numero_nomina) {
		Numero_nomina = numero_nomina;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public Float getDeducidos() {
		return deducidos;
	}

	public void setDeducidos(Float deducidos) {
		this.deducidos = deducidos;
	}

	public Float getIngresos() {
		return ingresos;
	}

	public void setIngresos(Float ingresos) {
		this.ingresos = ingresos;
	}

	public Float getTotalsalario() {
		return totalsalario;
	}

	public void setTotalsalario(Float totalsalario) {
		this.totalsalario = totalsalario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public empleado getEmpleados() {
		return empleados;
	}

	public void setEmpleados(empleado empleados) {
		this.empleados = empleados;
	}
	
	
	
	
	
	
	
	
	
	
	
}
	

	