import { TestBed } from '@angular/core/testing';

import { EmployeeSearchServiceService } from './employee-search-service.service';

describe('EmployeeSearchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EmployeeSearchServiceService = TestBed.get(EmployeeSearchServiceService);
    expect(service).toBeTruthy();
  });
});
