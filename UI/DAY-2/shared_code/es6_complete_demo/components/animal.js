class Animal {
    constructor(name) {
        this.name = name;
    }
    get name(){
        return this._name;
    }
    set name(value) {
        this._name = value;
    }

    toString() {
        return "Animal is " + this.name;
    }
}

export default function testAnimal() {
    let animal = new Animal("Cat");
    animal.name = 'Dog';
    console.log(animal);
}

