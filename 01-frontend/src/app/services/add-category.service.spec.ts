import { TestBed } from '@angular/core/testing';

import { AddCategoryService } from './add-category.service';

describe('AddCategoryService', () => {
  let service: AddCategoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddCategoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
