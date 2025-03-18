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

  // Objeto para almacenar los datos del alquiler.
  alquiler = {
    idUsuario: '',
    idVehiculo: '',
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
    // Recupera los parámetros de la URL y los almacena en el objeto alquiler.
    this.route.queryParams.subscribe(params => {
      if (params['idVehiculo']) {
        this.alquiler.idVehiculo = params['idVehiculo'];
        this.alquiler.color = params['color'];
        this.alquiler.valor_alquiler = params['valor_alquiler'];
      }
    });
  }

  solicitarAlquiler() {
    // URL del endpoint de solicitud de alquiler en el backend.
    const url = 'http://localhost:8080/ver/alquiler/solicitar';

    // Se envían los datos como parámetros en la solicitud POST.
    const params = {
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
    doc.text(`ID Usuario: ${this.alquiler.idUsuario}`, 20, 40);
    doc.text(`ID Vehículo: ${this.alquiler.idVehiculo}`, 20, 50);
    doc.text(`Color: ${this.alquiler.color}`, 20, 60);
    doc.text(`Valor Alquiler: ${this.alquiler.valor_alquiler}`, 20, 70);
    doc.text(`Fecha Inicio: ${this.alquiler.fechaInicio}`, 20, 80);
    doc.text(`Fecha Fin: ${this.alquiler.fechaFin}`, 20, 90);
    doc.text('Estado: Pendiente de entrega', 20, 100);
    doc.text('¡Gracias por su solicitud!', 20, 120);

    doc.save('solicitud-alquiler.pdf');
  }
}

