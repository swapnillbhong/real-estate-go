import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent  implements OnInit{
    image1="assets/img/carousel-1.jpg"

constructor(private router: Router) { }
ngOnInit(): void {
  }

  gonext(): void {
    this.router.navigate(['/agentsignin']);
  } 
}
