import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpitModalComponent } from './upit-modal.component';

describe('UpitModalComponent', () => {
  let component: UpitModalComponent;
  let fixture: ComponentFixture<UpitModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpitModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpitModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
