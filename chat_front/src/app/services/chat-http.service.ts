import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from '../modele/Message';
import {Chat} from '../modele/Chat';
import { Chats } from '../modele/Chats';

@Injectable({ providedIn: 'root' })
export class ChatHttpService {
  constructor(private http: HttpClient) {}

  createChat(): Observable<Chat> {
    return this.http.post<Chat>('/api/chat-support', {});
  }

  getMessages(chatId: string): Observable<Message[]> {
    return this.http.get<Message[]>(`/chat-support/${chatId}`);
  }

  saveMessage(chatId: string, message: Message): Observable<Message> {
    return this.http.post<Message>(`/chat-support/${chatId}/messages`, message);
  }

  getAllChats(): Observable<Chats[]> {
    return this.http.get<Chats[]>('/chat-support');
  }
}
