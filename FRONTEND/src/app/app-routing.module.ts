import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CommentServiceClient} from '../services/comment.service.client';
import {TestComponent} from './add-comment/test.component';
import {GetCommentComponent} from './get-comment/get-comment.component';
import {HomeComponent} from './home/home.component';
import {SignupComponent} from './signup/signup.component';
import {LoginComponent} from './login/login.component';
import {ArtistSearchComponent} from './movie-search/artist-search.component';
import {AdminComponent} from './admin/admin.component';
import {UpdatepersonComponent} from './updateperson/updateperson.component';
import {StaffComponent} from './staff/staff.component';
import {ManagerComponent} from './manager/manager.component';
import {LoginSearchComponent} from './login-search/login-search.component';
import {TicketComponent} from './ticket/ticket.component';
import {ActorComponent} from './actor/actor.component';
import {AddshowComponent} from './addshow/addshow.component';
import {UpdateshowComponent} from './updateshow/updateshow.component';
import {AddcommentadminComponent} from './addcommentadmin/addcommentadmin.component';

const routes: Routes = [
  {
    path: 'addcomment/:customerid1',
    component: TestComponent
  },
  {
    path: 'getcomment/:commentId',
    component: GetCommentComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'viewasguest',
    component: ArtistSearchComponent
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'update/:userId',
    component: UpdatepersonComponent
  },
  {
    path: 'staff',
    component: StaffComponent
  },
  {
    path: 'manager',
    component: ManagerComponent
  },
  {
    path: 'loginsearch/:customerid',
    component: LoginSearchComponent
  },
  {
    path: 'ticket/:customerid2',
    component: TicketComponent
  },
  {
    path: 'actor',
    component: ActorComponent
  },
  {
    path: 'addshow',
    component: AddshowComponent
  },
  {
    path: 'updateshow',
    component: UpdateshowComponent
  },
  {
    path: 'addcommentadmin',
    component: AddcommentadminComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
