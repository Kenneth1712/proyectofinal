package modelo;

import jakarta.persistence.*;
import java.util.Date;
import modelo.modeloUsuario;

@Entity
@Table(name = "alquiler")
public class modeloAlquiler {

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

    // Getters y Setters
}
