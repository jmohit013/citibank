import { Component, EventEmitter } from '@angular/core';
import {ActivatedRoute } from '@angular/router';

@Component({
    selector: 'first',
    template: `<div><h1>Inside First Component..</h1>
    <h2>{{title}}</h2>
    </div>`
})
export class FirstComponent {

    public activatedRoute: ActivatedRoute;
    public title:string;

    constructor(activatedRoute: ActivatedRoute) {
        this.activatedRoute = activatedRoute;
    }
    ngOnInit() {
        this.title = this.activatedRoute.snapshot.params['title'];
    }

}