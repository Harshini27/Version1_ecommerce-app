import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { CartItem } from "src/app/common/cart-item";
import { Product } from "src/app/common/product";
import { ProductService } from "src/app/services/product.service";
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: Product = new Product();
  products : Product[];
  namestore: any;
  emailstore:any;

  constructor(private productService: ProductService,
              private route: ActivatedRoute,public router:Router,private cartService: CartService) { }

  ngOnInit(): void {
    this.emailstore = localStorage.getItem("email");
    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
      this.namestore = localStorage.getItem("username");
      
    })
  }

  handleProductDetails() {

    // get the "id" param string. convert string to a number using the "+" symbol
    const theProductId: number = +this.route.snapshot.paramMap.get('id');

    this.productService.getProduct(theProductId).subscribe(
      data => {
        this.product = data;
      }
    )
  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }
  addToCart(theProduct: Product){
    console.log('Adding to cart: ${theProduct.name},${theProduct.unitPrice}');
    const theCartItem=new CartItem(theProduct);
    this.cartService.addToCart(theCartItem);
  }
   

}
