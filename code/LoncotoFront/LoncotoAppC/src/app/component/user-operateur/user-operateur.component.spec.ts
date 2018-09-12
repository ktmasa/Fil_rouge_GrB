import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOperateurComponent } from './user-operateur.component';

describe('UserOperateurComponent', () => {
  let component: UserOperateurComponent;
  let fixture: ComponentFixture<UserOperateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserOperateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserOperateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
