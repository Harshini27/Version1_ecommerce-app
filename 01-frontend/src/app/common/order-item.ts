import { CartItem } from "./cart-item";

export class OrderItem {
    imageUrl:string;
    unitPrice:number;
    quantity:number;
    productId:number;
    constructor(cartItem:CartItem){
        this.imageUrl=cartItem.imageUrl;
        this.quantity=cartItem.quantity;
        this.productId=cartItem.id;
        this.unitPrice=cartItem.unitPrice;
        
    }
}
