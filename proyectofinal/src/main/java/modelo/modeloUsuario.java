package modelo;

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

	    @Column(name = "contraseña", length = 255, nullable = false)
	    private String contraseña;

	    @Column(name = "numeroTel", length = 20, nullable = false)
	    private long numeroTel;

}
