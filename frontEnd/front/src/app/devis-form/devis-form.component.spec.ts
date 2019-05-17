import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DevisFormComponent } from './devis-form.component';

describe('DevisFormComponent', () => {
  let component: DevisFormComponent;
  let fixture: ComponentFixture<DevisFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DevisFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DevisFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
