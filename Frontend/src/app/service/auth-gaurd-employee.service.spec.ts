import { TestBed } from '@angular/core/testing';

import { AuthGaurdEmployeeService } from './auth-gaurd-employee.service';

describe('AuthGaurdEmployeeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthGaurdEmployeeService = TestBed.get(AuthGaurdEmployeeService);
    expect(service).toBeTruthy();
  });
});
