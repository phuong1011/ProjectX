import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditplaylistComponent } from './editplaylist.component';

describe('EditplaylistComponent', () => {
  let component: EditplaylistComponent;
  let fixture: ComponentFixture<EditplaylistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditplaylistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditplaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
