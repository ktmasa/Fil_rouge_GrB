import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeMaterielListComponent } from './ope-materiel-list.component';

describe('OpeMaterielListComponent', () => {
  let component: OpeMaterielListComponent;
  let fixture: ComponentFixture<OpeMaterielListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeMaterielListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeMaterielListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
