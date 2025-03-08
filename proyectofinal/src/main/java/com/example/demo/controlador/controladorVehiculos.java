package com.example.demo.controlador;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.modeloVehiculos;
import com.example.demo.repositorio.repositorioVehiculo;

@RestController
@RequestMapping("/vehiculo")
public class controladorVehiculos {

    @Autowired
    private repositorioVehiculo repositorio;

    @GetMapping("/verdisponible")
    public List<String> verDisponibles(@RequestParam String estado) {
        List<String> resultado = new LinkedList<>();
        List<modeloVehiculos> vehiculos = this.repositorio.findAll();

        for (modeloVehiculos vehiculo : vehiculos) {
            if (vehiculo.getEstado().equalsIgnoreCase(estado)) {
                resultado.add("Placa: " + vehiculo.getPlaca());
                resultado.add("Color: " + vehiculo.getColor());
                resultado.add("Valor Alquiler: " + vehiculo.getValor_alquiler());
                resultado.add("------");
            }
        }

        if (resultado.isEmpty()) {
            resultado.add("No hay vehículos disponibles con el estado: " + estado);
        }

        return resultado;
    }
    @GetMapping("/buscarPorTipo")
    public List<modeloVehiculos> buscarPorTipo(@RequestParam String tipo) {
        return repositorio.findByTipo(tipo);
    }
    @GetMapping("/seleccionar")
    public String seleccionarVehiculo(@RequestParam Long idVehiculo) {
        Optional<modeloVehiculos> vehiculoOpt = repositorio.findById(idVehiculo);

        if (!vehiculoOpt.isPresent()) {
            return "No se encontró un vehículo con ID " + idVehiculo;
        }

        modeloVehiculos vehiculo = vehiculoOpt.get();

        if (!vehiculo.getEstado().equalsIgnoreCase("disponible")) {
            return "El vehículo con ID " + idVehiculo + " no está disponible.";
        }

        vehiculo.setEstado("alquilado");
        repositorio.save(vehiculo);

        return "Vehículo con ID " + idVehiculo + " ha sido seleccionado con éxito.";
    }
}