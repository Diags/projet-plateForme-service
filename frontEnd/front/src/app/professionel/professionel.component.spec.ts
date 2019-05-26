import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionelComponent } from './professionel.component';

describe('ProfessionelComponent', () => {
  let component: ProfessionelComponent;
  let fixture: ComponentFixture<ProfessionelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessionelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessionelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
