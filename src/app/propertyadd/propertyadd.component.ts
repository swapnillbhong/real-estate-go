import { Component } from '@angular/core';
import { Propertyadd } from '../models/propertyadd.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PropertyaddService } from '../service/propertyadd.service';

@Component({
  selector: 'app-propertyadd',
  templateUrl: './propertyadd.component.html',
  styleUrl: './propertyadd.component.css'
})
export class PropertyaddComponent {
  propertyadd: Propertyadd;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private propertyaddservice: PropertyaddService) {
    this.propertyadd = new Propertyadd();
  }

  onSubmit() {
    this.propertyaddservice.addNewPropertyadd(this.propertyadd).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/']);
  }
}
