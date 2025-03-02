package controlador;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modelo.modeloUsuario;
import repositorio.repositorioUsuario;
import repositorio.repositorioVehiculo;


@RestController
@RequestMapping("/usuario/pagina")
public class controladorUsuario {
	
	 @Autowired
	 private repositorioUsuario repositorioUsuario;
	 private repositorioVehiculo repositorioVehiculos;

	 @GetMapping
	 public List <modeloUsuario>obtenerusuario(){
		 return repositorioUsuario.obtenertodos();
	 }
	 
	@PostMapping("/registrarse")
	public ResponseEntity<modeloUsuario> registrarUsuario(@RequestBody modeloUsuario usuario) {
		modeloUsuario nuevoUsuario = repositorioUsuario.registrar(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	 
}
	
	
	
	
}