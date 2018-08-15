import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOperateurMenuComponent } from './user-operateur-menu.component';

describe('UserOperateurMenuComponent', () => {
  let component: UserOperateurMenuComponent;
  let fixture: ComponentFixture<UserOperateurMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserOperateurMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserOperateurMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
