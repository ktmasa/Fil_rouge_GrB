import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperateurMainComponent } from './operateur-main.component';

describe('OperateurMainComponent', () => {
  let component: OperateurMainComponent;
  let fixture: ComponentFixture<OperateurMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperateurMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperateurMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
