import { Component } from '@angular/core';
import { Agent } from '../models/agent.model';
import { ActivatedRoute, Router } from '@angular/router';
import { AgentService } from '../service/agentservice.service';



@Component({
  selector: 'app-agentsignup',
  templateUrl: './agentsignup.component.html',
  styleUrl: './agentsignup.component.css'
})
export class AgentsignupComponent {
  agent: Agent;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private agentservice: AgentService) {
    this.agent = new Agent();
  }

  onSubmit() {
    this.agentservice.addNewAgent(this.agent).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/']);
  }
}
