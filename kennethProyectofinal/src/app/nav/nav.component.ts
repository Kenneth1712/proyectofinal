import { Component } from '@angular/core';
import { VehiculosComponent } from "../vehiculos/vehiculos.component";

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [VehiculosComponent],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

}
