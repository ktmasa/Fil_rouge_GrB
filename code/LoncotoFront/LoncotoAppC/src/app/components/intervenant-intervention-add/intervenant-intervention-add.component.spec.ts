import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntervenantInterventionAddComponent } from './intervenant-intervention-add.component';

describe('IntervenantInterventionAddComponent', () => {
  let component: IntervenantInterventionAddComponent;
  let fixture: ComponentFixture<IntervenantInterventionAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntervenantInterventionAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntervenantInterventionAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
