import { Component, EventEmitter } from '@angular/core';

@Component({
    selector: 'child',
    template: `<div><h2>Child Component..</h2>
                {{childTitle}}
                <br>
                Child textbox <input type='text' #childTextBox (keyup)="handleChildEvent(childTextBox.value)">
                </div>`,
    inputs: ['childTitle'],
    outputs: ['childEvent']
})
export class ChildComponent {
    public childTitle:string = 'blank title';
    public childEvent = new EventEmitter();

    handleChildEvent(childTextBoxValue: any) {
        this.childEvent.emit(childTextBoxValue);
    }
}