import { TestBed, inject } from '@angular/core/testing';

import { BatimentRepositoryService } from './batiment-repository.service';

describe('BatimentRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BatimentRepositoryService]
    });
  });

  it('should be created', inject([BatimentRepositoryService], (service: BatimentRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
