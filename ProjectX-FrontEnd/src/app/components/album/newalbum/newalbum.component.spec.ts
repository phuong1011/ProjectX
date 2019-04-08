import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewalbumComponent } from './newalbum.component';

describe('NewalbumComponent', () => {
  let component: NewalbumComponent;
  let fixture: ComponentFixture<NewalbumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewalbumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewalbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
