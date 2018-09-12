import { TestBed, inject } from '@angular/core/testing';

import { RelclientsiteRepositoryService } from './relclientsite-repository.service';

describe('RelclientsiteRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RelclientsiteRepositoryService]
    });
  });

  it('should be created', inject([RelclientsiteRepositoryService], (service: RelclientsiteRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
