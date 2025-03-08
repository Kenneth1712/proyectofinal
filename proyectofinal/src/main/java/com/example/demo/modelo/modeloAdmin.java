package com.example.demo.modelo;


import jakarta.persistence.*;
import jakarta.persistence.Column;
@Entity
@Table(name = "administrador")
public class modeloAdmin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdmin", nullable = false, unique = true)
    private Long idAdmin;


    @Column(name = "usuarioAdmin", length = 50, nullable = false, unique = true)
    private String usuarioAdmin;

    @Column(name = "contraseñaAdm", length = 255, nullable = false)
    private String contraseñaAdm;

	public modeloAdmin(Long idAdmin,String usuarioAdmin,String contraseñaAdm) {
		super();
		// TODO Auto-generated constructor stub
		this.idAdmin = idAdmin;
		this.usuarioAdmin = usuarioAdmin;
		this.contraseñaAdm=contraseñaAdm;
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getUsuarioAdmin() {
		return usuarioAdmin;
	}

	public void setUsuarioAdmin(String usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}

	public String getContraseñaAdm() {
		return contraseñaAdm;
	}

	public void setContraseñaAdm(String contraseñaAdm) {
		this.contraseñaAdm = contraseñaAdm;
	}

   
}



