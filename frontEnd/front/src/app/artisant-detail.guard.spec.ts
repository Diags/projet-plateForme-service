import { TestBed, async, inject } from '@angular/core/testing';

import { ArtisantDetailGuard } from './artisant-detail.guard';

describe('ArtisantDetailGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ArtisantDetailGuard]
    });
  });

  it('should ...', inject([ArtisantDetailGuard], (guard: ArtisantDetailGuard) => {
    expect(guard).toBeTruthy();
  }));
});
