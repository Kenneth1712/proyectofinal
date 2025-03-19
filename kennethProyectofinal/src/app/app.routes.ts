import { Routes } from '@angular/router';
import { RegistroComponent } from './pagina/registro/registro.component';
import { InicioSesionComponent } from './pagina/inicio-sesion/inicio-sesion.component';
import { NavComponent } from './nav/nav.component';
import { VehiculosComponent } from './vehiculos/vehiculos.component';
import { AlquilerComponent } from './alquiler/alquiler.component';
import { CancelarAlquilerComponent } from './cancelaralquiler/cancelaralquiler.component';

export const routes: Routes = [
  { path: '', redirectTo: '/registro', pathMatch: 'full' }, // ruta por defecto
  { path: 'registro', component: RegistroComponent },
  { path: 'inicio-sesion', component: InicioSesionComponent },
  { path: 'nav', component: NavComponent },
  
  { path: 'vehiculos', component: VehiculosComponent },
  { path: 'alquiler', component:AlquilerComponent },
  { path: 'cancelaralquiler', component: CancelarAlquilerComponent }
];
