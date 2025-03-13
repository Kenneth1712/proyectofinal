import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080/usuario/guardarU';

  constructor(private http: HttpClient) {}

  registrar(usuario: any): Observable<any> {
    const formData = new FormData();
    formData.append('idUsuario', usuario.idUsuario);
    formData.append('nombre', usuario.nombre);
    formData.append('fechaExpedicion', usuario.fechaExpedicion);
    formData.append('vigencia', usuario.vigencia);
    formData.append(' correoElectronico', usuario.correoElectronico);
    formData.append('numeroTel', usuario.numeroTel);
    formData.append('categoria', usuario.categoria);
    return this.http.post(this.apiUrl, formData);
  }

  registrarCredenciales(idUsuario: number, password: string): Observable<any> {
    const formData = new FormData();
    formData.append('identificacion', idUsuario.toString());
    formData.append('contraseña', password);
  
    return this.http.post('http://localhost:8080/usuario/login', formData);
  }
  
}