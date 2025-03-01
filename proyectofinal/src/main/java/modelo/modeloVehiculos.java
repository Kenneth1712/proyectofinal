package modelo;
import jakarta.persistence.*;


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

    @Column(name = "valorAlquiler", nullable = false)
    private Double valorAlquiler;

   
}

