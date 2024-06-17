import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custsignin',
  templateUrl: './custsignin.component.html',
  styleUrl: './custsignin.component.css'
})
export class CustsigninComponent implements OnInit {
  username: any;
  password: any;
  message: any;
  constructor(private router: Router) { }
  ngOnInit(): void {
  }
}
