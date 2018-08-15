import { TestBed, inject } from '@angular/core/testing';

import { EtageRepositoryService } from './etage-repository.service';

describe('EtageRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EtageRepositoryService]
    });
  });

  it('should be created', inject([EtageRepositoryService], (service: EtageRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
