import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SampleComponent } from './components/sample.component';
import { ChildComponent } from './components/child.component';
import { ProductComponent } from './components/product.component';
import { FormsModule } from '@angular/forms';
//import { ProductService } from './services/product.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { getLocaleFirstDayOfWeek } from '@angular/common';
import { FirstComponent } from './components/first.component';
import { SecondComponent } from './components/second.component';

@NgModule({
  declarations: [
    AppComponent, SampleComponent, ChildComponent, ProductComponent, FirstComponent, SecondComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot([
        { path: 'first/:title', component: FirstComponent},
        { path: 'second', component: SecondComponent}
    ])
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
