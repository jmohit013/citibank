import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ProductService {

    public baseUrl:string = 'http://localhost:8080/myapp';

    public httpClient: HttpClient;
    constructor(httpClient: HttpClient) {
        this.httpClient = httpClient;
    }
    addProduct(productObj:any) {
        console.log('Product pushed into an array: ');
    }

    getProducts() {
        return this.httpClient.get(this.baseUrl + '/product');
    }
}