import { Injectable } from '@angular/core';
import { Client, IMessage, Stomp } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { BehaviorSubject, Observable } from 'rxjs';
import {Message} from '../modele/Message';

@Injectable({ providedIn: 'root' })
export class ChatWebsocketService {
  private stompClient: Client | null = null;
  private messagesSubject = new BehaviorSubject<any>(null);
  public messages$: Observable<IMessage> = this.messagesSubject.asObservable();

  connect(chatId: string) {
    this.stompClient = Stomp.over(() => new SockJS('/websocket'));
    this.stompClient.onConnect = () => {
      this.stompClient?.subscribe(
        `/support/${chatId}`,
        (message: IMessage) => {
          if (message.body) {
            this.messagesSubject.next(JSON.parse(message.body));
          }
        }
      );
    };
    this.stompClient.activate();
  }

  sendMessage(chatId: string, msg: Message) {
    if (this.stompClient && this.stompClient.connected) {
      this.stompClient.publish({
        destination: `/app/support/${chatId}`,
        body: JSON.stringify(msg),
      });
    }
  }

  disconnect() {
    this.stompClient?.onWebSocketClose(() => {});
    this.stompClient = null;
  }
}
