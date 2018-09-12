import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientSiteListComponent } from './client-site-list.component';

describe('ClientSiteListComponent', () => {
  let component: ClientSiteListComponent;
  let fixture: ComponentFixture<ClientSiteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientSiteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientSiteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
