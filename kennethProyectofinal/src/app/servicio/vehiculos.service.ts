import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehiculos } from '../entidades/vehiculos';
import { FormsModule } from '@angular/forms'; // 👈 Importar aquí también


@Injectable({
  providedIn: 'root'
})
export class VehiculosService {

  private baseUrl = 'http://localhost:8080/vehiculo';

  constructor(private http: HttpClient) {}

  getVehiculosDisponibles(tipo: string): Observable<Vehiculos[]> {
    const params = new HttpParams().set('tipo', tipo);
    return this.http.get<Vehiculos[]>(`${this.baseUrl}/buscarDisponibles`, { params });
  }
}