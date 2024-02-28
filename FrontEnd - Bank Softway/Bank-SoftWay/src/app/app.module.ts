import { NgModule } from '@angular/core';                                         // Módulo                     
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';// Navegador

import { AppRoutingModule } from './app-routing.module';                          // Rotas
import { AppComponent } from './app.component';                                   // Componente principal 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';   // Animações
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';                           // Bootstrap


// Components do projeto
import { ComponentsComponent } from './components/components.component';          // Components
import { HomeComponent } from './components/home/home.component';                 // Home
import { NavbarComponent } from './components/navbar/navbar.component';           // Navbar
import { BannerComponent } from './components/banner/banner.component';           // Banner



// Material Design
import { MatToolbarModule } from '@angular/material/toolbar';         // Toolbar
import { MatButtonModule } from '@angular/material/button';           // Botão
import { MatIconModule } from '@angular/material/icon';               // Ícones
import { MatInputModule } from '@angular/material/input';             // Input
import { MatFormFieldModule } from '@angular/material/form-field';    // Formulário
import { AlertModule } from '@coreui/angular';                        // Alertas
import { CarouselModule } from '@coreui/angular';                     // Carousel
import { IconDirective } from '@coreui/icons-angular';                // Ícones




@NgModule({
  declarations: [
    AppComponent,
    ComponentsComponent,
    HomeComponent,
    NavbarComponent,
    BannerComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    AlertModule,
    CarouselModule,
  ],

  providers: [
    provideClientHydration()
  ],
  bootstrap: [ AppComponent ]
  
})
export class AppModule { }








