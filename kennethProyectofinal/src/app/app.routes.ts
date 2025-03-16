import { Routes } from '@angular/router';
import { RegistroComponent } from './pagina/registro/registro.component';
import { InicioSesionComponent } from './pagina/inicio-sesion/inicio-sesion.component';
import { NavComponent } from './nav/nav.component';
import { VehiculosComponent } from './vehiculos/vehiculos.component';

export const routes: Routes = [
  { path: 'registrarse', component: RegistroComponent },
  { path: 'inicio-sesion', component: InicioSesionComponent } ,// Agrega esta línea
  //{ path: '', redirectTo: 'inicio-sesion', pathMatch: 'full' },
  //{ path: '**', redirectTo: 'inicio-sesion' }
  { path: 'nav', component: NavComponent }, 
  {path: "vehiculos", component:VehiculosComponent }
]; 