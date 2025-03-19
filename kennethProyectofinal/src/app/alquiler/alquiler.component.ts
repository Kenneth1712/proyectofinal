import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { jsPDF } from 'jspdf';

@Component({
  selector: 'app-alquiler',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './alquiler.component.html',
  styleUrls: ['./alquiler.component.css']
})
export class AlquilerComponent implements OnInit {

  alquiler = {
    nombre: '',
    idUsuario: '',
    idVehiculo: '',
    placa: '',
    tipo: '',
    color: '',
    valor_alquiler: '',
    fechaInicio: '',
    fechaFin: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['idVehiculo']) {
        this.alquiler.idVehiculo = params['idVehiculo'];
        this.alquiler.placa = params['placa'] || 'No disponible';
        this.alquiler.tipo = params['tipo'] || 'No disponible';
        this.alquiler.color = params['color'] || 'No disponible';
        this.alquiler.valor_alquiler = params['valor_alquiler'] || 'No disponible';
      }
    });
  }

  solicitarAlquiler() {
    const url = 'http://localhost:8080/ver/alquiler/solicitar';

    const params = {
      nombre: this.alquiler.nombre,
      idUsuario: this.alquiler.idUsuario,
      idVehiculo: this.alquiler.idVehiculo,
      fechaInicio: this.alquiler.fechaInicio,
      fechaFin: this.alquiler.fechaFin
    };

    this.http.post(url, null, { params }).subscribe({
      next: () => {
        alert('Alquiler solicitado con éxito.');
        this.generarPDF();
      },
      error: (err) => {
        alert('Error al solicitar el alquiler: ' + err.error);
      }
    });
  }

  generarPDF() {
    const doc = new jsPDF();

    doc.setFontSize(16);
    doc.text('Solicitud de Alquiler', 20, 20);

    doc.setFontSize(12);
    doc.text(`Nombre: ${this.alquiler.nombre}`, 20, 40);
    doc.text(`ID Usuario: ${this.alquiler.idUsuario}`, 20, 50);
    doc.text(`ID Vehículo: ${this.alquiler.idVehiculo}`, 20, 60);
    doc.text(`Placa: ${this.alquiler.placa}`, 20, 70);
    doc.text(`Tipo: ${this.alquiler.tipo}`, 20, 80);
    doc.text(`Color: ${this.alquiler.color}`, 20, 90);
    doc.text(`Valor Alquiler: ${this.alquiler.valor_alquiler}`, 20, 100);
    doc.text(`Fecha Inicio: ${this.alquiler.fechaInicio}`, 20, 110);
    doc.text(`Fecha Fin: ${this.alquiler.fechaFin}`, 20, 120);
    doc.text('Estado: Pendiente de entrega', 20, 130);
    doc.text('¡Gracias por su solicitud!', 20, 150);

    doc.save('solicitud-alquiler.pdf');
  }
}
