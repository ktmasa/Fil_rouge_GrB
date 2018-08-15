import { TestBed, inject } from '@angular/core/testing';

import { SalleRepositoryService } from './salle-repository.service';

describe('SalleRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalleRepositoryService]
    });
  });

  it('should be created', inject([SalleRepositoryService], (service: SalleRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
