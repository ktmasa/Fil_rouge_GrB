import { TestBed, inject } from '@angular/core/testing';

import { InterventionRepositoryService } from './intervention-repository.service';

describe('InterventionRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InterventionRepositoryService]
    });
  });

  it('should be created', inject([InterventionRepositoryService], (service: InterventionRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
