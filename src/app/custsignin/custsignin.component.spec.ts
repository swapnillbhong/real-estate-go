import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustsigninComponent } from './custsignin.component';

describe('CustsigninComponent', () => {
  let component: CustsigninComponent;
  let fixture: ComponentFixture<CustsigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustsigninComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CustsigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
