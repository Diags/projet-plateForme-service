import { TestBed, async, inject } from '@angular/core/testing';

import { ProfessionelGuard } from './professionel.guard';

describe('ProfessionelGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProfessionelGuard]
    });
  });

  it('should ...', inject([ProfessionelGuard], (guard: ProfessionelGuard) => {
    expect(guard).toBeTruthy();
  }));
});
