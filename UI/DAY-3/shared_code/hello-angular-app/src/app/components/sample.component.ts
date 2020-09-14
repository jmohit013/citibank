import { Component } from '@angular/core';

@Component({
    selector: 'sample',
    template: `<div><h1>Hello {{company}}</h1>
                <br><br>
                <img [src]="showImage"/>
                <br><br>
                Account details: {{accountObj | json}}
                <br><br>
               <h2> Currency Value: {{currencyValue | currency:'CAD' }}</h2>
                <br><br>
                <input type="text" #myname [(ngModel)]="username"> {{username}}
                <br><br>
                <p *ngIf="showPara">This is citibank paragraph</p>
                <br><br>
                <ul>
                    <li *ngFor="let city of cities">{{city}}</li>
                </ul>
                <br><br>

                <div class="myClass">My division</div>
                <div [ngClass]="{myClass: shouldApplyCss}">My division 2</div>

                <br><br>
                <input type="submit" value="OK" (click)="handleClickEvent(myname)">
                
            </div>`,
    styles: ['.myClass { background-color: cyan;}']
})
export class SampleComponent {

    public accountObj = { id: 101, name: 'Tom', balance: 10000};
    public currencyValue = 21.35;

    public shouldApplyCss:boolean = false;
    public showPara:boolean = false;
    public cities = ['Pune', 'Mumbai', 'Delhi'];

    public company:string = 'Citi Bank';
    public showImage:string = 'https://angular.io/assets/images/logos/angular/logo-nav@2x.png';
    public username:string = '';
    public password:string = '';

    handleClickEvent(elementRef: any) {
        console.log('OK button clicked: ', elementRef.value);
    }
}
