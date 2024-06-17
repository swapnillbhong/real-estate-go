import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { AgentsigninComponent } from './agentsignin/agentsignin.component';
import { AgentsignupComponent } from './agentsignup/agentsignup.component';
import { CustsigninComponent } from './custsignin/custsignin.component';
import { CustsignupComponent } from './custsignup/custsignup.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { PropertyComponent } from './property/property.component';
import { AgentdashboardComponent } from './agentdashboard/agentdashboard.component';
import { PropertyaddComponent } from './propertyadd/propertyadd.component';
import { AppointmentdatailsComponent } from './appointmentdatails/appointmentdatails.component';
const routes: Routes = [{ path: '', component: HomeComponent },
{ path: 'about', component: AboutComponent },
{ path: 'agentsignin', component: AgentsigninComponent },
{ path: 'agentsignup', component: AgentsignupComponent },
{ path: 'custsignin', component: CustsigninComponent },
{ path: 'custsignup', component: CustsignupComponent },
{ path: 'appointment', component: AppointmentComponent },
{ path: 'property', component: PropertyComponent },

{ path: 'appointmentdatails', component: AppointmentdatailsComponent },
{ path: 'agentdashboard', component: AgentdashboardComponent },
{ path: 'propertyadd', component: PropertyaddComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
