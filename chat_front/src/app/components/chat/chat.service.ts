import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ChatService {
  constructor(private http: HttpClient) {}

  sendMessage(message: string): Observable<any> {
    return this.http.post('/api/messages', { text: message });
  }

  createChat(): Observable<any> {
    return this.http.post('/api/chats', {});
  }
}
