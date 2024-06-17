import { Component } from '@angular/core';
import { Customer } from '../models/customer.model';
import { ActivatedRoute, Router } from '@angular/router';

import { CustomerService } from '../service/customerservice.service';

@Component({
  selector: 'app-custsignup',
  templateUrl: './custsignup.component.html',
  styleUrl: './custsignup.component.css'
})
export class CustsignupComponent {
  customer: Customer;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private customerservice: CustomerService) {
    this.customer = new Customer();
  }

  onSubmit() {
    this.customerservice.addNewCustomer(this.customer).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/']);
  }
}
