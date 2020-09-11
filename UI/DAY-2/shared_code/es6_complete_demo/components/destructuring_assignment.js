export function testDestructuringAssignment() {
    var nos = [10, 20, 30, 40];
    
    //var no_first = nos[0];
    //var no_last = nos[3]; //ES5
    let [no_first,,,no_last ] = nos; //De-structuring an array

    let [x,,,y] = [10, 20, 30, 40];
    console.log(x, y);

    let {id, title} = {id: 546, title: 'Fruit Delivery', price: 5200.85}; 
    console.log("Id:", id, "Title:", title);

    let cust = { 
            name: "Microsoft Corp.", 
            address: { 
                street: "J. M. Road", 
                city: "Pune", 
                state: "Maharashtra", 
                zip: "411002" 
            } 
    }; 
    let {address: {city, state}} = cust; //Deep matching
    console.log("City:", city, "State:", state);

    //Fail-soft destructuring
    let list = [ 7, 42 ]; 
    let [a = 1, b = 2, c = 3, d] = list; //Fail-soft de-structuring with default values.
    console.log("a:", a, "\nb:", b, "\nc:", c, "\nd:", d); 

}