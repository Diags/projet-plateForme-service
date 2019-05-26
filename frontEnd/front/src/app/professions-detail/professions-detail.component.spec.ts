import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionsDetailComponent } from './professions-detail.component';

describe('ProfessionsDetailComponent', () => {
  let component: ProfessionsDetailComponent;
  let fixture: ComponentFixture<ProfessionsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessionsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessionsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
