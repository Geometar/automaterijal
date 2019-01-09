import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KategorijaSpecificnaComponent } from './kategorija-specificna.component';

describe('KategorijaSpecificnaComponent', () => {
  let component: KategorijaSpecificnaComponent;
  let fixture: ComponentFixture<KategorijaSpecificnaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KategorijaSpecificnaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KategorijaSpecificnaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
