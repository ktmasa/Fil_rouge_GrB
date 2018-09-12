import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpeImageListComponent } from './ope-image-list.component';

describe('OpeImageListComponent', () => {
  let component: OpeImageListComponent;
  let fixture: ComponentFixture<OpeImageListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpeImageListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpeImageListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
