import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { WhyComponent } from './why/why.component';
import { FooterComponent } from './footer/footer.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UserhomeComponent } from './userhome/userhome.component';
import { PlandetailsComponent } from './plandetails/plandetails.component';
import { SavingComponent } from './saving/saving.component';
import { ProfileComponent } from './profile/profile.component';
@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    WhyComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    UserhomeComponent,
    PlandetailsComponent,
    SavingComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
}) 
export class AppModule { }
