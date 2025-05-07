import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ChatHttpService {
  constructor(private http: HttpClient) {}

  createChat(): Observable<any> {
    return this.http.post('/api/chats', {});
  }

  getMessages(chatId: string): Observable<any[]> {
    return this.http.get<any[]>(`/chats/${chatId}`);
  }

  saveMessage(chatId: string, message: any): Observable<any> {
    return this.http.post(`/chats/${chatId}/messages`, message);
  }

  getAllChats(): Observable<any[]> {
    return this.http.get<any[]>(`/chats`);
  }
}
