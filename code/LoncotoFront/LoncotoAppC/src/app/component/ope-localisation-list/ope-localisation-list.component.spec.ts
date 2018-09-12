import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeLocalisationListComponent } from './ope-localisation-list.component';

describe('OpeLocalisationListComponent', () => {
  let component: OpeLocalisationListComponent;
  let fixture: ComponentFixture<OpeLocalisationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeLocalisationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeLocalisationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
