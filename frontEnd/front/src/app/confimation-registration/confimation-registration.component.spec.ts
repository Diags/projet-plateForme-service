import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfimationRegistrationComponent } from './confimation-registration.component';

describe('ConfimationRegistrationComponent', () => {
  let component: ConfimationRegistrationComponent;
  let fixture: ComponentFixture<ConfimationRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfimationRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfimationRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
