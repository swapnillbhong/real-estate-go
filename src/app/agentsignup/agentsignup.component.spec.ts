import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentsignupComponent } from './agentsignup.component';

describe('AgentsignupComponent', () => {
  let component: AgentsignupComponent;
  let fixture: ComponentFixture<AgentsignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AgentsignupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgentsignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
