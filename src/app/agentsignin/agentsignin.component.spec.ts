import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentsigninComponent } from './agentsignin.component';

describe('AgentsigninComponent', () => {
  let component: AgentsigninComponent;
  let fixture: ComponentFixture<AgentsigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AgentsigninComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgentsigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
