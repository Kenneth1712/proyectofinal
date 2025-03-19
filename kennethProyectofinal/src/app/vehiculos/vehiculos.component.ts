import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculosService } from '../servicio/vehiculos.service';
import { Vehiculos } from '../entidades/vehiculos';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css']
})
export class VehiculosComponent implements OnInit {

  tipo: string = 'automovil';
  vehiculos: Vehiculos[] = [];

  paginaActual: number = 1;
  vehiculosPorPagina: number = 5;
  totalPaginas: number = 1;

  constructor(
    private vehiculosService: VehiculosService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.verDisponibles();
  }

  verDisponibles(): void {
    console.log(`Tipo seleccionado: ${this.tipo}`);

    this.vehiculosService.getVehiculosDisponibles(this.tipo).subscribe(
      (data: Vehiculos[]) => {
        console.log('Datos recibidos:', data);
        this.vehiculos = data;
        this.totalPaginas = Math.ceil(this.vehiculos.length / this.vehiculosPorPagina);
        this.paginaActual = 1; 
      },
      (error: any) => {
        console.error('Error al obtener los vehículos:', error);
      }
    );
  }

  // Métodos de paginación
  paginaAnterior(): void {
    if (this.paginaActual > 1) {
      this.paginaActual--;
    }
  }

  paginaSiguiente(): void {
    if (this.paginaActual < this.totalPaginas) {
      this.paginaActual++;
    }
  }

  get vehiculosPaginados(): Vehiculos[] {
    const inicio = (this.paginaActual - 1) * this.vehiculosPorPagina;
    const fin = inicio + this.vehiculosPorPagina;
    return this.vehiculos.slice(inicio, fin);
  }
  
  alquilar(vehiculo: Vehiculos): void {
    this.router.navigate(['/alquiler'], { 
      queryParams: { 
        idVehiculo: vehiculo.idVehiculo, 
        placa: vehiculo.placa, 
        tipo: vehiculo.tipo, 
        color: vehiculo.color, 
        valor_alquiler: vehiculo.valor_alquiler 
      } 
    });
  }
}
