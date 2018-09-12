import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntervenantMainComponent } from './intervenant-main.component';

describe('IntervenantMainComponent', () => {
  let component: IntervenantMainComponent;
  let fixture: ComponentFixture<IntervenantMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntervenantMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntervenantMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
