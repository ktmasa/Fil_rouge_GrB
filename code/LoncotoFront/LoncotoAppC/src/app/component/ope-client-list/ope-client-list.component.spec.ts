import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeClientListComponent } from './ope-client-list.component';

describe('OpeClientListComponent', () => {
  let component: OpeClientListComponent;
  let fixture: ComponentFixture<OpeClientListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeClientListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeClientListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
