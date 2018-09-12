import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInterventionsSiteListComponent } from './client-interventions-site-list.component';

describe('ClientInterventionsSiteListComponent', () => {
  let component: ClientInterventionsSiteListComponent;
  let fixture: ComponentFixture<ClientInterventionsSiteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientInterventionsSiteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInterventionsSiteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
