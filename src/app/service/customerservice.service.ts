import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Customer } from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = 'http://Estate-env-1.eba-bxsetkgg.eu-north-1.elasticbeanstalk.com/custsignup';

  constructor(private http: HttpClient) { }

  // Add a new User
  addNewCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.baseUrl, customer)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Update an existing customer
  updateCustomer(customerId: string, updatedCustomer: Customer): Observable<Customer> {
    const url = `${this.baseUrl}/${customerId}`;
    return this.http.put<Customer>(url, updatedCustomer)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Get all customers
  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Find a customer by ID
  findCustomerById(id: string): Observable<Customer> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Customer>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Handle errors
  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error); // Return an observable that emits the error
  }
}
