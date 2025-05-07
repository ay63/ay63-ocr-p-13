import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {ChatHttpService} from '../../services/chat-http.service';


@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private chatHttpService: ChatHttpService, private router: Router) {}

  openChat() {
    this.chatHttpService.createChat().subscribe({
      next: (chat: any) => {
        if (chat && chat.id) {
          this.router.navigate(['/chat', chat.id]);
        }
      },
      error: (err) => {
        console.error('Erreur création chat', err);
      }
    });
  }
}
