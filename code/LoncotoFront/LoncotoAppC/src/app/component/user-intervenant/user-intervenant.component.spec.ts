import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserIntervenantComponent } from './user-intervenant.component';

describe('UserIntervenantComponent', () => {
  let component: UserIntervenantComponent;
  let fixture: ComponentFixture<UserIntervenantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserIntervenantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserIntervenantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
