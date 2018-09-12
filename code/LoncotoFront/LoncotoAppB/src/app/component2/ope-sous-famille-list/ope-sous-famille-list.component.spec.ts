import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeSousFamilleListComponent } from './ope-sous-famille-list.component';

describe('OpeSousFamilleListComponent', () => {
  let component: OpeSousFamilleListComponent;
  let fixture: ComponentFixture<OpeSousFamilleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeSousFamilleListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeSousFamilleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
