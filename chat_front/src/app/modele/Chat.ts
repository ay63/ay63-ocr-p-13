import {Client} from './Client';
import {Message} from './Message';

export interface Chat {
  id: string;
  createdAt: string;
  client: Client;
  messages: Message[];
}

