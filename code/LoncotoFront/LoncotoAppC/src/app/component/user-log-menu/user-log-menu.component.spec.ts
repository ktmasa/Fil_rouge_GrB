import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLogMenuComponent } from './user-log-menu.component';

describe('UserLogMenuComponent', () => {
  let component: UserLogMenuComponent;
  let fixture: ComponentFixture<UserLogMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserLogMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLogMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
