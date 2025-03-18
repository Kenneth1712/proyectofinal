import { Component, OnInit } from '@angular/core';
import { AlquilerService } from '../servicio/alquiler.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-cancelar-alquiler',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cancelaralquiler.component.html',
  styleUrls: ['./cancelaralquiler.component.css']
  
})
export class CancelarAlquilerComponent implements OnInit {
  idUsuario: number | null = null;
  alquileres: any[] = [];

  constructor(private alquilerService: AlquilerService) {}

  ngOnInit(): void {}

  buscarAlquileres() {
    if (!this.idUsuario) {
      alert('Por favor ingrese un ID de usuario válido');
      return;
    }

    this.alquilerService.obtenerAlquileresPorUsuario(this.idUsuario).subscribe({
      next: (res) => this.alquileres = res,
      error: (err) => alert('Error al obtener alquileres: ' + err.error)
    });
  }

  cancelarAlquiler(idAlquiler: number) {
    if (!confirm('¿Está seguro de que desea cancelar este alquiler?')) {
      return;
    }

    this.alquilerService.cancelarAlquiler(idAlquiler).subscribe({
      next: () => {
        alert('Alquiler cancelado con éxito');
        this.alquileres = this.alquileres.filter(a => a.idAlquiler !== idAlquiler);
      },
      error: (err) => alert('Error al cancelar alquiler: ' + err.error)
    });
  }
}

