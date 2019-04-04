import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BandsintownClient} from '../services/movie.service.client';
import { ArtistSearchComponent } from './movie-search/artist-search.component';
import {FormsModule} from '@angular/forms';
import { TestComponent } from './add-comment/test.component';
import {HttpClientModule} from '@angular/common/http';
import {CommentServiceClient} from '../services/comment.service.client';
import { GetCommentComponent } from './get-comment/get-comment.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import {AdminServiceClient} from '../services/admin.service.client';
import { UpdatepersonComponent } from './updateperson/updateperson.component';
import { StaffComponent } from './staff/staff.component';
import { ManagerComponent } from './manager/manager.component';
import { LoginSearchComponent } from './login-search/login-search.component';
import { TicketComponent } from './ticket/ticket.component';
import { ShowComponent } from './show/show.component';
import { ActorComponent } from './actor/actor.component';
import {ActorServiceClient} from '../services/actor.service.client';
import { AddshowComponent } from './addshow/addshow.component';
import { UpdateshowComponent } from './updateshow/updateshow.component';
import { AddcommentadminComponent } from './addcommentadmin/addcommentadmin.component';

@NgModule({
  declarations: [
    AppComponent,
    ArtistSearchComponent,
    TestComponent,
    GetCommentComponent,
    HomeComponent,
    SignupComponent,
    LoginComponent,
    AdminComponent,
    UpdatepersonComponent,
    StaffComponent,
    ManagerComponent,
    LoginSearchComponent,
    TicketComponent,
    ShowComponent,
    ActorComponent,
    AddshowComponent,
    UpdateshowComponent,
    AddcommentadminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [BandsintownClient, AdminServiceClient, ActorServiceClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
