import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntervenantInterventionListComponent } from './intervenant-intervention-list.component';

describe('IntervenantInterventionListComponent', () => {
  let component: IntervenantInterventionListComponent;
  let fixture: ComponentFixture<IntervenantInterventionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntervenantInterventionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntervenantInterventionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
