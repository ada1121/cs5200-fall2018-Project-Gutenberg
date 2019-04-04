import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcommentadminComponent } from './addcommentadmin.component';

describe('AddcommentadminComponent', () => {
  let component: AddcommentadminComponent;
  let fixture: ComponentFixture<AddcommentadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddcommentadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcommentadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
