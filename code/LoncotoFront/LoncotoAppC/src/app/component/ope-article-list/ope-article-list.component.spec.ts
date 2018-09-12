import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeArticleListComponent } from './ope-article-list.component';

describe('OpeArticleListComponent', () => {
  let component: OpeArticleListComponent;
  let fixture: ComponentFixture<OpeArticleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeArticleListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeArticleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
