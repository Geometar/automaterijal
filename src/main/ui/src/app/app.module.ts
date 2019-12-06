import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { StorageServiceModule } from 'angular-webstorage-service';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ModalModule } from './shared/modal/modal.module';
import { NavigacijaModule } from './navigacija/navigacija.module';
import { AuthGuard } from './shared/guard/auth-guard';
import { HttpErrorInterceptor } from './shared/interceptor/error-interceptor';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    ModalModule,
    HttpModule,
    HttpClientModule,
    NavigacijaModule,
    StorageServiceModule,
    BrowserAnimationsModule,
    AppRoutingModule,
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
