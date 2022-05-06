import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviseV2Component } from './devise-v2.component';

describe('DeviseV2Component', () => {
  let component: DeviseV2Component;
  let fixture: ComponentFixture<DeviseV2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeviseV2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeviseV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
