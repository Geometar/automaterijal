import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KampanjaComponent } from './kampanja.component';

describe('KampanjaComponent', () => {
  let component: KampanjaComponent;
  let fixture: ComponentFixture<KampanjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KampanjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KampanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
