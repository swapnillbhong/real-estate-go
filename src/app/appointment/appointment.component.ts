import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrl: './appointment.component.css'
})
export class AppointmentComponent {
appointment: any = {}; // Object to store form data

  constructor() {}

  submitAppointment() {
    // Logic to submit the appointment form data
    console.log('Form submitted:', this.appointment);
  }
}
