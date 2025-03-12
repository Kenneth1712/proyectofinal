package com.example.demo.modelo;
import jakarta.persistence.Column;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class modeloUsuario {
	
	
	
	
	@Id
	@Column(name="idUsuario")
	private Long idUsuario;
	
	 @Column(name = "nombre", length = 50, nullable = false)
	    private String nombre;

	    @Column(name = "fechaExpedicion", nullable = false)
	    private Date fechaExpedicion;

	    @Column(name = "categoria", length = 20, nullable = false)
	    private String categoria;

	    @Column(name = "correoElectronico", length = 100, nullable = false, unique = true)
	    private String correoElectronico;

	    @Column(name = "vigencia", nullable = false)
	    private String vigencia;

	    @Column(name = "password", length = 255, nullable = false)
	    private String password;

	    @Column(name = "numeroTel", length = 20, nullable = false)
	    private long numeroTel;

		public modeloUsuario() {
			super();
			// TODO Auto-generated constructor stub
		}
		public modeloUsuario ( Long idUsuario, String nombre, Date fechaExpedicion, String categoria, String correoElectronico, String vigencia, String password,Long numeroTel, 
				modeloAlquiler alquiler) {
			super();
			this.idUsuario = idUsuario;
			this.nombre = nombre;
			this.fechaExpedicion = fechaExpedicion;
			this.categoria = categoria;
			this.correoElectronico = correoElectronico;
			this.vigencia = vigencia;
			this.password = password;
			this.numeroTel = numeroTel;

		}
		
		

		public Long getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Date getFechaExpedicion() {
			return fechaExpedicion;
		}

		public void setFechaExpedicion(Date fechaExpedicion) {
			this.fechaExpedicion = fechaExpedicion;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getCorreoElectronico() {
			return correoElectronico;
		}

		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}

		public String getVigencia() {
			return vigencia;
		}

		public void setVigencia(String vigencia) {
			this.vigencia = vigencia;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public long getNumeroTel() {
			return numeroTel;
		}

		public void setNumeroTel(long numeroTel) {
			this.numeroTel = numeroTel;
		}
		
		
		
}
