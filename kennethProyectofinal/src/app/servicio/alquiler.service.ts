import { Injectable } from '@angular/core';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alquiler } from '../entidades/alquiler';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {
  private baseUrl = 'http://localhost:8080/ver/alquiler';

  constructor(private http: HttpClient) {}

  solicitarAlquiler(idUsuario: number, idVehiculo: number, fechaInicio: string, fechaFin: string): Observable<Alquiler> {
    const params = new HttpParams()
      .set('idUsuario', idUsuario.toString())
      .set('idVehiculo', idVehiculo.toString())
      .set('fechaInicio', fechaInicio)
      .set('fechaFin', fechaFin);
    
    return this.http.post<Alquiler>(`${this.baseUrl}/solicitar`, {}, { params });
  }

  obtenerTodosLosAlquileres(): Observable<Alquiler[]> {
    return this.http.get<Alquiler[]>(`${this.baseUrl}/todos`);
  }

  cancelarAlquiler(idAlquiler: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/cancelarAlqui`, { params: { idAlquiler } });
  }
}
