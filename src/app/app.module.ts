import { NgModule } from '@angular/core';
// import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { AgentsigninComponent } from './agentsignin/agentsignin.component';
import { AgentsignupComponent } from './agentsignup/agentsignup.component';
import { CustsigninComponent } from './custsignin/custsignin.component';
import { CustsignupComponent } from './custsignup/custsignup.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { CustomerService } from './service/customerservice.service';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { PropertyComponent } from './property/property.component';
import { AppointmentdatailsComponent } from './appointmentdatails/appointmentdatails.component';
import { PropertyaddComponent } from './propertyadd/propertyadd.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    AgentsigninComponent,
    AgentsignupComponent,
    CustsigninComponent,
    CustsignupComponent,
    AppointmentComponent,
    PropertyComponent,
    AppointmentdatailsComponent,
    PropertyaddComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,

  ],
  providers: [
    CustomerService,
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
