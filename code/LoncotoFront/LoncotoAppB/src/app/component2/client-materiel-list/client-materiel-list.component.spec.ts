import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMaterielListComponent } from './client-materiel-list.component';

describe('ClientMaterielListComponent', () => {
  let component: ClientMaterielListComponent;
  let fixture: ComponentFixture<ClientMaterielListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMaterielListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMaterielListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
