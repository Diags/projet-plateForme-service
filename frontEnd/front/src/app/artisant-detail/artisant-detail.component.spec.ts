import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtisantDetailComponent } from './artisant-detail.component';

describe('ArtisantDetailComponent', () => {
  let component: ArtisantDetailComponent;
  let fixture: ComponentFixture<ArtisantDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtisantDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtisantDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
