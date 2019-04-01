import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NabbarComponent } from './nabbar.component';

describe('NabbarComponent', () => {
  let component: NabbarComponent;
  let fixture: ComponentFixture<NabbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NabbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NabbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
