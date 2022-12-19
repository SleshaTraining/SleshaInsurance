import { TestBed } from '@angular/core/testing';

import { PlandetailsService } from './plandetails.service';

describe('PlandetailsService', () => {
  let service: PlandetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlandetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
