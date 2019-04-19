import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BrendoviModalComponent } from './brendovi-modal.component';

describe('BrendoviModalComponent', () => {
  let component: BrendoviModalComponent;
  let fixture: ComponentFixture<BrendoviModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BrendoviModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BrendoviModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
