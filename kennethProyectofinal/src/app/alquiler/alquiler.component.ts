import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../servicio/alquiler.service';
import { VehiculosService } from '../servicio/vehiculos.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculos } from '../entidades/vehiculos';
import { Alquiler } from '../entidades/alquiler';

@Component({
  selector: 'app-alquiler',
  standalone: true,
  imports: [],
  templateUrl: './alquiler.component.html',
  styleUrl: './alquiler.component.css'
})
export class AlquilerComponent implements OnInit {
  vehiculos: Vehiculos[] = [];
  tipo: string = 'automovil';
  alquiler: Alquiler = new Alquiler();
  mostrarFormulario: boolean = false;

  constructor(private alquilerService: AlquilerService, private vehiculosService: VehiculosService) {}

  ngOnInit(): void {
    this.verDisponibles();
  }

  verDisponibles(): void {
    this.vehiculosService.getVehiculosDisponibles(this.tipo).subscribe(
      (data: Vehiculos[]) => {
        this.vehiculos = data;
      },
      (error: any) => {
        console.error('Error al obtener los vehículos:', error);
      }
    );
  }

  mostrarFormularioAlquiler(vehiculo: Vehiculos): void {
    this.alquiler.idVehiculo= vehiculo.idVehiculo;
    this.mostrarFormulario = true;
  }

  solicitarAlquiler(): void {
    this.alquilerService.solicitarAlquiler(
      this.alquiler.idUsuario,
      this.alquiler.idVehiculo,
      this.alquiler.fechaInicio.toISOString().split('T')[0],  // Formato 'YYYY-MM-DD'
      this.alquiler.fechaFin.toISOString().split('T')[0]
    ).subscribe({
      next: response => {
        alert('Alquiler solicitado exitosamente.');
        this.mostrarFormulario = false;
        this.verDisponibles();
      },
      error: error => {
        console.error('Error al solicitar el alquiler:', error);
        alert('Error al solicitar el alquiler.');
      }
    });
  }
   }