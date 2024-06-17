import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustsignupComponent } from './custsignup.component';

describe('CustsignupComponent', () => {
  let component: CustsignupComponent;
  let fixture: ComponentFixture<CustsignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustsignupComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CustsignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
