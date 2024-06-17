import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyaddComponent } from './propertyadd.component';

describe('PropertyaddComponent', () => {
  let component: PropertyaddComponent;
  let fixture: ComponentFixture<PropertyaddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PropertyaddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PropertyaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
