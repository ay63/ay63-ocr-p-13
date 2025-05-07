import {Client} from './Client';

export interface Chat {
  id: string;
  createdAt: string;
  client: Client;
  messages: any[];
}

