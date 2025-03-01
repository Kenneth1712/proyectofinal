package modelo;

import jakarta.persistence.*;

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

   
}

