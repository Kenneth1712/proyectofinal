import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UsuarioService } from '../../servicio/usuario.service';


@Component({
  selector: 'app-registro',
  standalone: true, 
  imports: [CommonModule, FormsModule, RouterOutlet],
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent {

mostrar: boolean = true;

  usuario = {
    idUsuario: '',
    nombre: '',
    fechaExpedicion: '',
    vigencia: '',
    correoElectronico: '',
    numeroTel: '',
    categoria:'',
    password: '',
   
  }; 

  constructor(private usuarioService: UsuarioService, private _router: Router) {}

  ngOnInit(): void {
    this._router.events.subscribe((event: any) => {
      if (event instanceof NavigationEnd) {
      
        if (event.url !== '/nav') {                   // Ocultar el formulario si la ruta no es la principal
          this.mostrar = false;
        }
      }
    });
  }


  registrarUsuario() {
    this.usuarioService.registrar(this.usuario).subscribe({
      next:respuesta => {
        alert('Usuario registrado exitosamente');
      },
      error: error => {
        
        if (error.status === 400) {
          alert('Error: Datos inválidos. Verifique la información ingresada.');
        } else if (error.status === 500) {
          alert('Error del servidor. Intente más tarde.');
        } else {
          alert('Error desconocido al registrar usuario.');
          console.error(error);
        }
      }
  });
  }

  sesion(){
    this.mostrar= false;
    this._router.navigateByUrl('/inicio-sesion')
    
  }

  ocultar(){
    this.mostrar= false;
  }
}