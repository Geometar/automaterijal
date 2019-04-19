import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistracijaModalComponent } from './registracija-modal.component';

describe('RegistracijaModalComponent', () => {
  let component: RegistracijaModalComponent;
  let fixture: ComponentFixture<RegistracijaModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistracijaModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistracijaModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
