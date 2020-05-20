import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerLeaveListComponent } from './manager-leave-list.component';

describe('ManagerLeaveListComponent', () => {
  let component: ManagerLeaveListComponent;
  let fixture: ComponentFixture<ManagerLeaveListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerLeaveListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerLeaveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
