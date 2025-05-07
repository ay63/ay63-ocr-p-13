import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChatHttpService } from '../../services/chat-http.service';
import { NgForOf, NgIf, DatePipe } from '@angular/common';

@Component({
  selector: 'app-support',
  standalone: true,
  imports: [NgForOf, NgIf, DatePipe],
  templateUrl: './support.component.html',
  styleUrls: ['./support.component.css']
})
export class SupportComponent implements OnInit {
  chats: any[] = [];

  constructor(private chatHttp: ChatHttpService, private router: Router) { }

  ngOnInit() {
    this.chatHttp.getAllChats().subscribe(chats => {
      this.chats = chats;
    });
  }

  openChat(chatId: string) {
    this.router.navigate(['/chat', chatId], { state: { fromSupport: true } });
  }
}