import { TestBed, inject } from '@angular/core/testing';

import { SousFamilleRepositoryService } from './sous-famille-repository.service';

describe('SousFamilleRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SousFamilleRepositoryService]
    });
  });

  it('should be created', inject([SousFamilleRepositoryService], (service: SousFamilleRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
