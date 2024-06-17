import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Propertyadd } from '../models/propertyadd.model';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PropertyaddService {

  private baseUrl = 'http://Estate-env-1.eba-bxsetkgg.eu-north-1.elasticbeanstalk.com/propertyAdd';

  constructor(private http: HttpClient) { }

  // Add a new User
  addNewPropertyadd(propertyadd: Propertyadd): Observable<Propertyadd> {
    return this.http.post<Propertyadd>(this.baseUrl, propertyadd)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Update an existing propertyadd
  updatePropertyadd(propertyaddId: string, updatedPropertyadd: Propertyadd): Observable<Propertyadd> {
    const url = `${this.baseUrl}/${propertyaddId}`;
    return this.http.put<Propertyadd>(url, updatedPropertyadd)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Get all propertyadds
  getAllPropertyadds(): Observable<Propertyadd[]> {
    return this.http.get<Propertyadd[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Find a propertyadd by ID
  findPropertyaddById(id: string): Observable<Propertyadd> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Propertyadd>(url)
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
