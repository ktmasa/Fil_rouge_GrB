import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInterventionsListComponent } from './client-interventions-list.component';

describe('ClientInterventionsListComponent', () => {
  let component: ClientInterventionsListComponent;
  let fixture: ComponentFixture<ClientInterventionsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientInterventionsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInterventionsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
