import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agent } from '../models/agent.model';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentService {
  private baseUrl = 'http://Estate-env-1.eba-bxsetkgg.eu-north-1.elasticbeanstalk.com/agentSignUp';

  constructor(private http: HttpClient) { }

  // Add a new customer
  addNewAgent(agent: Agent): Observable<Agent> {
    return this.http.post<Agent>(this.baseUrl, agent)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Update an existing customer
  updateAgent(agentId: string, updatedAgent: Agent): Observable<Agent> {
    const url = `${this.baseUrl}/${agentId}`;
    return this.http.put<Agent>(url, updatedAgent)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Get all customers
  getAllAgents(): Observable<Agent[]> {
    return this.http.get<Agent[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  // Find a customer by ID
  findAgentById(id: string): Observable<Agent> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Agent>(url)
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
