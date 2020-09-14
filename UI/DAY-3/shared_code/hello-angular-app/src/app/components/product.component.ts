import { Component, EventEmitter } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Observable } from 'rxjs';

@Component({
    selector: 'product-form',
    template: `<form #productForm="ngForm" (ngSubmit)="onSubmit(productForm.value)" novalidate>
    <div class="container">
        <div class="form-group">
            
            <input type="text" name="name" required class="form-control" placeholder=“Name” #nameModelRef="ngModel" ngModel>
            <div [hidden]="nameModelRef.valid || nameModelRef.pristine" class="alert alert-danger">
                Please enter product name
            </div>
        </div>    
        <div class="form-group">
            <input type="text" name="quantity" required class="form-control" placeholder=“Quantity” ngModel>
        </div>
        <div class="form-group">
            <input type="text" name="price" required class="form-control" placeholder=“Price” ngModel>
        </div>
        <button type="submit" [disabled]="!productForm.form.valid" class="btn btn-primary">ADD PRODUCT</button>
    </div>

    <ul>
        <li *ngFor="let product of products">{{product | json}}</li>
    </ul>
    </form>`,
    providers: [ProductService]
})
export class ProductComponent {

    public products = [];
    public productService: ProductService;

    constructor(productService: ProductService) {
        this.productService = productService;
        let observable:Observable<Object> = productService.getProducts();
        observable.subscribe((response:any)=>this.products = response);
    }

    onSubmit(productFormValue: any) {
        console.log('Submitting product form: ', productFormValue);
        console.log('product quantity: ', productFormValue.quantity);
        this.productService.addProduct(productFormValue);
    }
}