import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NextIntervenantInterventionComponent } from './next-intervenant-intervention.component';

describe('NextIntervenantInterventionComponent', () => {
  let component: NextIntervenantInterventionComponent;
  let fixture: ComponentFixture<NextIntervenantInterventionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NextIntervenantInterventionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NextIntervenantInterventionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
