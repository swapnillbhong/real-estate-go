import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentdatailsComponent } from './appointmentdatails.component';

describe('AppointmentdatailsComponent', () => {
  let component: AppointmentdatailsComponent;
  let fixture: ComponentFixture<AppointmentdatailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AppointmentdatailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AppointmentdatailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
