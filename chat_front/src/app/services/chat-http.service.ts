import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Message} from '../modele/Message';
import {Chat} from '../modele/Chat';

@Injectable({ providedIn: 'root' })
export class ChatHttpService {
  constructor(private http: HttpClient) {}

  createChat(): Observable<Chat> {
    return this.http.post<Chat>('/api/chats', {});
  }

  getMessages(chatId: string): Observable<Message[]> {
    return this.http.get<Message[]>(`/chats/${chatId}`);
  }

  saveMessage(chatId: string, message: Message): Observable<any> {
    return this.http.post(`/chats/${chatId}/messages`, message);
  }

  getAllChats(): Observable<Message[]> {
    return this.http.get<Message[]>(`/chats`);
  }
}
