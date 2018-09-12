import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeFamilleListComponent } from './ope-famille-list.component';

describe('OpeFamilleListComponent', () => {
  let component: OpeFamilleListComponent;
  let fixture: ComponentFixture<OpeFamilleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeFamilleListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeFamilleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
