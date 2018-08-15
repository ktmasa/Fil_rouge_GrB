import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserIntervenantMenuComponent } from './user-intervenant-menu.component';

describe('UserIntervenantMenuComponent', () => {
  let component: UserIntervenantMenuComponent;
  let fixture: ComponentFixture<UserIntervenantMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserIntervenantMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserIntervenantMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
