import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientInterventionListComponent } from './client-intervention-list.component';

describe('ClientInterventionListComponent', () => {
  let component: ClientInterventionListComponent;
  let fixture: ComponentFixture<ClientInterventionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientInterventionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientInterventionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
