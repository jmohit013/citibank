export function testTemplateLiterals() {
    
    let poem = `Twinkle, twinkle, little star, 
                How I wonder what you are! 
                Up above the world so high, 
                Like a diamond in the sky!`;
    
    
    
    stringInterpolation("Ashwin", 12000, 3000, "Pune");
}

function stringInterpolation(name, salary, incentive, city) {
   // var emp_info = 'My name is ' + name + ... //ES5
    let employee_info = `My name is ${name},\nmy total salary is ${salary + incentive}\nI stay at ${city}`; //ES6
    console.log(employee_info);
}