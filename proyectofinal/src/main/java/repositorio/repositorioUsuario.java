package repositorio;

import java.util.List;
import modelo.modeloUsuario;

public interface repositorioUsuario {

	List<modeloUsuario> obtenertodos();

	modeloUsuario registrar(modeloUsuario usuario);

}
