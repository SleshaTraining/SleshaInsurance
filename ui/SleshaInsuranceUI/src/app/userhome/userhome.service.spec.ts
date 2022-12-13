import { TestBed } from '@angular/core/testing';

import { UserhomeService } from './userhome.service';

describe('UserhomeService', () => {
  let service: UserhomeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserhomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
