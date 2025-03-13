import { Routes } from '@angular/router';
import { RegistroComponent } from './pagina/registro/registro.component';

import { InicioSesionComponent } from './pagina/inicio-sesion/inicio-sesion.component';

export const routes: Routes = [
  { path: 'registrarse', component: RegistroComponent },
  { path: 'inicio-sesion', component: InicioSesionComponent }, // Agrega esta línea
  { path: '', redirectTo: 'inicio-sesion', pathMatch: 'full' },
  { path: '**', redirectTo: 'inicio-sesion' }
];
