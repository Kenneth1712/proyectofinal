import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  private apiUrl = 'http://localhost:8080/ver/alquiler';

  constructor(private http: HttpClient) {}

  obtenerAlquileresPorUsuario(idUsuario: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/mostrarAlquileres?idUsuario=${idUsuario}`);
  }

  cancelarAlquiler(idAlquiler: number): Observable<void> {
    return this.http.get<void>(`${this.apiUrl}/cancelarAlqui?idAlquiler=${idAlquiler}`);
  }
}
