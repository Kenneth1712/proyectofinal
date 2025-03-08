package com.example.demo.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "vehiculo")
public class modeloVehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo", nullable = false, unique = true)
    private Long idVehiculo;

    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;

    @Column(name = "placa", length = 10, nullable = false, unique = true)
    private String placa;

    @Column(name = "color", length = 20, nullable = false)
    private String color;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado; // "disponible" o "alquilado"

    @Column(name = "valor_alquiler", nullable = false)
    private Double valor_alquiler;

    public modeloVehiculos() {}
	public modeloVehiculos(Long idVehiculo,String tipo,String placa,String color,String estado,Double valor_alquiler) {
		super();
		// TODO Auto-generated constructor stub
		this.idVehiculo=idVehiculo;
		this.tipo=tipo;
		this.placa=placa;
		this.color=color;
		this.estado=estado;
		this.valor_alquiler=valor_alquiler;
				
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getValor_alquiler() {
		return valor_alquiler;
	}

	public void setValor_alquiler(Double valor_alquiler) {
		this.valor_alquiler = valor_alquiler;
	}
}