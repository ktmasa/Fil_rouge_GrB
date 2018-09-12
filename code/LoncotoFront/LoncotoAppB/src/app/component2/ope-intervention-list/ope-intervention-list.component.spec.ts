import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeInterventionListComponent } from './ope-intervention-list.component';

describe('OpeInterventionListComponent', () => {
  let component: OpeInterventionListComponent;
  let fixture: ComponentFixture<OpeInterventionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeInterventionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeInterventionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
