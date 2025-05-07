import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ChatService } from '../chat/chat.service';
import { RouterLink } from '@angular/router';
import { NgIf, NgOptimizedImage } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, NgOptimizedImage, NgIf],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private chatService: ChatService, private router: Router) {}

  openChat() {
    this.chatService.createChat().subscribe({
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
