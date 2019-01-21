import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResetovanjeSfireComponent } from './resetovanje-sfire.component';

describe('ResetovanjeSfireComponent', () => {
  let component: ResetovanjeSfireComponent;
  let fixture: ComponentFixture<ResetovanjeSfireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResetovanjeSfireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResetovanjeSfireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
