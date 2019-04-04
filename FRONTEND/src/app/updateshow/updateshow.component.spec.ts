import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateshowComponent } from './updateshow.component';

describe('UpdateshowComponent', () => {
  let component: UpdateshowComponent;
  let fixture: ComponentFixture<UpdateshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
