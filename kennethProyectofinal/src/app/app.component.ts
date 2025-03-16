import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, RouterOutlet } from '@angular/router';
import { RegistroComponent } from './pagina/registro/registro.component';
import { InicioSesionComponent } from "./pagina/inicio-sesion/inicio-sesion.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ RegistroComponent, HttpClientModule,FormsModule,CommonModule],  // Agrega HttpClientModule aquí
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  title = 'proyectofinal'; }