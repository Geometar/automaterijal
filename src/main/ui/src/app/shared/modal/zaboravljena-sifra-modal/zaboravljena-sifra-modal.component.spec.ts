import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZaboravljenaSifraModalComponent } from './zaboravljena-sifra-modal.component';

describe('ZaboravljenaSifraModalComponent', () => {
  let component: ZaboravljenaSifraModalComponent;
  let fixture: ComponentFixture<ZaboravljenaSifraModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZaboravljenaSifraModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZaboravljenaSifraModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
