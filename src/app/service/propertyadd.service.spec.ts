import { TestBed } from '@angular/core/testing';

import { PropertyaddService } from './propertyadd.service';

describe('PropertyaddService', () => {
  let service: PropertyaddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertyaddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
