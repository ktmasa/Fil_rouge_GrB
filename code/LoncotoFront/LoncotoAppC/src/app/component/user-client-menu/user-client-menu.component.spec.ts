import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserClientMenuComponent } from './user-client-menu.component';

describe('UserClientMenuComponent', () => {
  let component: UserClientMenuComponent;
  let fixture: ComponentFixture<UserClientMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserClientMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserClientMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
