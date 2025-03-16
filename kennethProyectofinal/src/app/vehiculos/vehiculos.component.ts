import { Component, OnInit } from '@angular/core';
import { VehiculosService } from '../servicio/vehiculos.service';
import { Vehiculos } from '../entidades/vehiculos';
import { FormsModule } from '@angular/forms'; // 👈 Importar aquí también
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../servicio/usuario.service';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { RegistroComponent } from "../pagina/registro/registro.component";

@Component({
  selector: 'app-vehiculos',
  standalone:true,
  imports: [CommonModule, FormsModule],
  providers:[RegistroComponent],
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css']
})

export class VehiculosComponent implements OnInit {

  
  tipo: string = 'automovil'; // Tipo por defecto
  vehiculos: Vehiculos[] = [];

  constructor(private vehiculosService: VehiculosService) {}

  ngOnInit(): void {
    this.verDisponibles();
    
  }

  verDisponibles(): void {
    console.log(`Tipo seleccionado: ${this.tipo}`); // Verifica en consola el valor seleccionado

    this.vehiculosService.getVehiculosDisponibles(this.tipo).subscribe(
      (data: Vehiculos[]) => {
        console.log('Datos recibidos:', data); // Verifica en consola los datos recibidos
        this.vehiculos = data;
      },
      (error: any) => {
        console.error('Error al obtener los vehículos:', error);
      }
    );
  }
  
}