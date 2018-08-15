import { TestBed, inject } from '@angular/core/testing';

import { ArticleRepositoryService } from './article-repository.service';

describe('ArticleRepositoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ArticleRepositoryService]
    });
  });

  it('should be created', inject([ArticleRepositoryService], (service: ArticleRepositoryService) => {
    expect(service).toBeTruthy();
  }));
});
