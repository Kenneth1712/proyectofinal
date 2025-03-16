import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { jsPDF } from 'jspdf';  // Asegúrate de haber instalado jsPDF

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
    fechaInicio: '',
    fechaFin: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    // Recupera el id del vehículo de los parámetros de la URL.
    this.route.queryParams.subscribe(params => {
      if (params['idVehiculo']) {
        this.alquiler.idVehiculo = params['idVehiculo'];
      }
    });
  }

  solicitarAlquiler() {
    // URL del endpoint de solicitud de alquiler en el backend.
    const url = 'http://localhost:8080/ver/alquiler/solicitar';
    
    // Se asume que el backend espera estos parámetros como query params.
    const params = {
      idUsuario: this.alquiler.idUsuario,
      idVehiculo: this.alquiler.idVehiculo,
      fechaInicio: this.alquiler.fechaInicio,
      fechaFin: this.alquiler.fechaFin
    };

    this.http.post(url, null, { params }).subscribe({
      next: (res) => {
        alert('Alquiler solicitado con éxito.');
        // Genera el PDF tras confirmar la solicitud
        this.generarPDF();
        // Opcional: redirigir o limpiar el formulario.
        // this.router.navigate(['/vehiculos']);
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
    doc.text(`Fecha Inicio: ${this.alquiler.fechaInicio}`, 20, 60);
    doc.text(`Fecha Fin: ${this.alquiler.fechaFin}`, 20, 70);
    doc.text('¡Gracias por su solicitud!', 20, 90);
    
    // Guarda y descarga el PDF con el nombre especificado.
    doc.save('solicitud-alquiler.pdf');
  }
}
