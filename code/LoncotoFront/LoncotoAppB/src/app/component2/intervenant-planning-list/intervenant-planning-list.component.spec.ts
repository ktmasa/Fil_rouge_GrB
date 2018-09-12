import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntervenantPlanningListComponent } from './intervenant-planning-list.component';

describe('IntervenantPlanningListComponent', () => {
  let component: IntervenantPlanningListComponent;
  let fixture: ComponentFixture<IntervenantPlanningListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntervenantPlanningListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntervenantPlanningListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
