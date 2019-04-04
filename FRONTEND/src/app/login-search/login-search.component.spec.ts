import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginSearchComponent } from './login-search.component';

describe('LoginSearchComponent', () => {
  let component: LoginSearchComponent;
  let fixture: ComponentFixture<LoginSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
