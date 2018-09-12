import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInterventionsMaterielListComponent } from './client-interventions-materiel-list.component';

describe('ClientInterventionsMaterielListComponent', () => {
  let component: ClientInterventionsMaterielListComponent;
  let fixture: ComponentFixture<ClientInterventionsMaterielListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientInterventionsMaterielListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInterventionsMaterielListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
