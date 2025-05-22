import {Customer} from './Customer';
import {Message} from './Message';

export interface Chat {
  id: string;
  createdAt: string;
  customer: Customer;
  messages: Message[];
}

