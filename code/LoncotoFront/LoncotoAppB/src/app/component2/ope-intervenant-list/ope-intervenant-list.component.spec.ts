import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeIntervenantListComponent } from './ope-intervenant-list.component';

describe('OpeIntervenantListComponent', () => {
  let component: OpeIntervenantListComponent;
  let fixture: ComponentFixture<OpeIntervenantListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeIntervenantListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeIntervenantListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
