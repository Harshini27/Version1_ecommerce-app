import { LoginComponent } from "../components/login/login.component";
import { Order } from "./order";
import {OrderItem} from './order-item';
import { User } from "./user";
export class Purchase {
    user:User
    order:Order;
    orderItems:OrderItem[];
    
}
