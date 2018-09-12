import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientSitesListComponent } from './client-sites-list.component';

describe('ClientSitesListComponent', () => {
  let component: ClientSitesListComponent;
  let fixture: ComponentFixture<ClientSitesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientSitesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientSitesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
