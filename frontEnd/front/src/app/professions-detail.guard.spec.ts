import { TestBed, async, inject } from '@angular/core/testing';

import { ProfessionsDetailGuard } from './professions-detail.guard';

describe('ProfessionsDetailGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProfessionsDetailGuard]
    });
  });

  it('should ...', inject([ProfessionsDetailGuard], (guard: ProfessionsDetailGuard) => {
    expect(guard).toBeTruthy();
  }));
});
