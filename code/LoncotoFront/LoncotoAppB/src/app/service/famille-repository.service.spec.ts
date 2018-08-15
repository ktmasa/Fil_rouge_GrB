import { TestBed, inject } from '@angular/core/testing';

import { FamilleRepositoryService } from './famille-repository.service';

describe('FamilleRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FamilleRepositoryService]
    });
  });

  it('should be created', inject([FamilleRepositoryService], (service: FamilleRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
