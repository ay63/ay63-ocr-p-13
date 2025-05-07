import { Component, OnInit, OnDestroy, HostListener } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { DatePipe, NgClass, NgForOf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChatWebsocketService } from '../../services/chat-websocket.service';
import { filter } from 'rxjs/operators';
import { ChatHttpService } from '../../services/chat-http.service';

@Component({
  selector: 'app-chat',
  imports: [NgClass, FormsModule, NgForOf, DatePipe],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit, OnDestroy {
  messages: any[] = [];
  newMsg: string = '';
  role: string = 'user';
  chatId: string = '';

  constructor(
    private chatWs: ChatWebsocketService,
    private chatHttp: ChatHttpService,
    private route: ActivatedRoute
  ) { }


  ngOnInit() {
    const nav = window.history.state;
    if (nav && nav.fromSupport) {
      this.role = 'support';
    } else {
      this.role = 'user';
    }
    this.route.paramMap.subscribe(params => {
      const chatId = params.get('id');
      if (chatId) {
        this.chatId = chatId;
        this.chatHttp.getMessages(this.chatId).subscribe(messages => {
          this.messages = messages || [];
          setTimeout(() => this.scrollToBottom(), 100);
        });
        this.chatWs.connect(this.chatId);
        this.chatWs.messages$
          .pipe(
            filter(msg => !!msg)
          )
          .subscribe((msg: any) => {
            console.log('Message reçu dans le composant:', msg);
            this.messages.push(msg);
            setTimeout(() => this.scrollToBottom(), 100);
          });
      }
    });
  }

  ngOnDestroy() {
    this.chatWs.disconnect();
  }

  @HostListener('keydown.enter', ['$event'])
  send() {
    if (!this.newMsg.trim()) return;
    const msg = {
      sender: this.role,
      content: this.newMsg.trim(),
      timestamp: new Date()
    };

    this.chatHttp.saveMessage(this.chatId, msg).subscribe();
    // Ne pas ajouter manuellement le message ici
    // Il sera ajouté automatiquement via WebSocket
    this.chatWs.sendMessage(this.chatId, msg);
    this.newMsg = '';
    setTimeout(() => this.scrollToBottom(), 100);
  }

  scrollToBottom() {
    const container = document.querySelector('.messages');
    if (container) {
      container.scrollTop = container.scrollHeight;
    }
  }
}

