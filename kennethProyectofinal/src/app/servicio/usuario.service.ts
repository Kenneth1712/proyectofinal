import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { response } from 'express';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/usuario';

  constructor(private http: HttpClient) {}

  registrar(usuario: any): Observable<string> {
    const formData = new FormData();
    formData.append('idUsuario', usuario.idUsuario);
    formData.append('nombre', usuario.nombre);
    formData.append('fechaExpedicion', usuario.fechaExpedicion);
    formData.append('vigencia', usuario.vigencia);
    formData.append('correoElectronico', usuario.correoElectronico);
    formData.append('numeroTel', usuario.numeroTel);
    formData.append('categoria', usuario.categoria);
    formData.append('password', usuario.password);
    return this.http.post(`${this.apiUrl}/guardarU`, formData, { responseType: 'text' });
  }

  iniciarSesion(idUsuario: string, password: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/login`, {
      params: { idUsuario, password }
    });
  }
  
   }