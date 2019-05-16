import { TestBed, async, inject } from '@angular/core/testing';

import { CatalogDetailGuard } from './catalog-detail.guard';

describe('CatalogDetailGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CatalogDetailGuard]
    });
  });

  it('should ...', inject([CatalogDetailGuard], (guard: CatalogDetailGuard) => {
    expect(guard).toBeTruthy();
  }));
});
