import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntervenenantMainComponent } from './intervenenant-main.component';

describe('IntervenenantMainComponent', () => {
  let component: IntervenenantMainComponent;
  let fixture: ComponentFixture<IntervenenantMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntervenenantMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntervenenantMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
