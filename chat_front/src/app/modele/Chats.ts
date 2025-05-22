import { Customer } from "./Customer";
import { Message } from "./Message";


export interface Chats {
    id: string;
    createdAt: string;
    customer: Customer;
    messages: Message[];
}

