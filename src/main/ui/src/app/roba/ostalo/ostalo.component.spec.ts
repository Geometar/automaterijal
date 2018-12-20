import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OstaloComponent } from './ostalo.component';

describe('OstaloComponent', () => {
  let component: OstaloComponent;
  let fixture: ComponentFixture<OstaloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OstaloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OstaloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
