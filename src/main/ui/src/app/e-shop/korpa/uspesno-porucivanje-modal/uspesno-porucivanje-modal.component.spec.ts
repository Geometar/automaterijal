import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UspesnoPorucivanjeModalComponent } from './uspesno-porucivanje-modal.component';

describe('UspesnoPorucivanjeModalComponent', () => {
  let component: UspesnoPorucivanjeModalComponent;
  let fixture: ComponentFixture<UspesnoPorucivanjeModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UspesnoPorucivanjeModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UspesnoPorucivanjeModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
