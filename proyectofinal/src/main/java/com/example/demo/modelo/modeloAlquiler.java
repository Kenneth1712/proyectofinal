package com.example.demo.modelo;
import jakarta.persistence.Column;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "alquiler")
public class modeloAlquiler{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlquiler", nullable = false, unique = true)
    private Long idAlquiler;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private modeloUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", nullable = false)
    private modeloVehiculos vehiculo;

    @Column(name = "fechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "estadoAlquiler", length = 30, nullable = false)
    private String estadoAlquiler; // "pendiente de entrega" o "entregado"

    @Column(name = "verificar", length = 10, nullable = false)
    private String verificar;

    @Column(name = "actividadAlquiler", length = 50, nullable = false)
    private String actividadAlquiler;
    

    public modeloAlquiler() {
        this.verificar = "false";
        this.actividadAlquiler = "No especificada";
    }

	public modeloAlquiler(long idAlquiler, Long idUsuario,Long idVehiculo, Date fechaInicio,Date fechaFin,String estadoAlquiler,String verificar, String actividadAlquiler) {
		super();
		this.idAlquiler=idAlquiler;
		
		this.fechaInicio= fechaInicio;
		this.fechaFin=fechaFin;
		this.estadoAlquiler=estadoAlquiler;
		this.verificar=verificar;
		this.actividadAlquiler=actividadAlquiler;
		
	}

	public Long getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Long idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public modeloUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(modeloUsuario usuario) {
		this.usuario = usuario;
	}

	public modeloVehiculos getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(modeloVehiculos vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstadoAlquiler() {
		return estadoAlquiler;
	}

	public void setEstadoAlquiler(String estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

	public String getVerificar() {
		return verificar;
	}

	public void setVerificar(String verificar) {
		this.verificar = verificar;
	}

	public String getActividadAlquiler() {
		return actividadAlquiler;
	}

	public void setActividadAlquiler(String actividadAlquiler) {
		this.actividadAlquiler = actividadAlquiler;
	}

  
}

