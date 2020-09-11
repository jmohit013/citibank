export function testExtendedParameterHandling() {
    //greet();
    //greet("Hi");
    //greet(undefined,"Jerry");

    restParametersFunc(32, 43, 767, 34);
var nos = [10, 20, 30];
spreadOperator(nos[0], nos[1], nos[2]); //ES5
spreadOperator(...nos); //ES6
}

function greet(msg="Hello", name="Tom") {
    console.log(msg, name);
}


function restParametersFunc(x, ...y) {
    console.log("rest parameter y = ", y);
}

function spreadOperator(a, b, c) {
    console.log("Total sum = ", (a + b + c))
}