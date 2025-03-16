import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../../servicio/usuario.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-inicio-sesion',
  standalone: true, 
  imports: [CommonModule, FormsModule],
  templateUrl: './inicio-sesion.component.html',
  styleUrls: ['./inicio-sesion.component.scss']
})
export class InicioSesionComponent {
  credenciales = { idUsuario: '', password: '' };
  mensajeError = '';

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  iniciarSesion() {
    if (this.credenciales.idUsuario && this.credenciales.password) {
      console.log("Datos enviados:", this.credenciales);
  
      this.usuarioService.iniciarSesion(this.credenciales.idUsuario, this.credenciales.password)
        .subscribe((res) => {
          console.log("Respuesta del servidor:", res);
          
          if (res && res.mensaje) {
            console.log('Inicio de sesión correcto');
            alert(res.mensaje);
            this.router.navigate(['/nav']); // Cambia '/dashboard' por la ruta correcta
          } else {
            console.log('Inicio de sesión incorrecto');
            alert('Usuario o contraseña incorrectos');
            this.credenciales = { idUsuario: '', password: '' }; // Resetea los campos
          }
        }, (error) => {
          console.error("Error en la petición:", error);
          alert('Usuario o contraseña incorrectos');
        });
    } else {
      alert('Por favor, complete todos los campos');
    }
  }
  
}