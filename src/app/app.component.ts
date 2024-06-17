import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Estate1.2';
  

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToNextPage(): void  {
    this.router.navigate(['/home']); // Replace '/next-page' with the route you want to navigate to
  }
}
