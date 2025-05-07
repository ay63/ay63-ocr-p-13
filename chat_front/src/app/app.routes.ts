import { Routes } from '@angular/router';
import {ChatComponent} from './components/chat/chat.component';
import {NotfoundComponent} from './components/notfound/notfound.component';
import {SupportComponent} from './components/support/support.component';
import { HomeComponent } from './components/home/home.component';


export const routes: Routes = [
  { path: '',  component: HomeComponent },
  { path: 'chat/:id', component: ChatComponent },
  { path: 'support', component: SupportComponent },
  { path: '**', component: NotfoundComponent },

];
