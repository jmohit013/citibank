
export function testScoping() {
    if(5 > 3) {
        let u = 20;
        console.log("U = ", u);
        document.write("<h2>U = " + u + "</h2>");
    }

    document.write("<h2>U = " + u + "</h2>"); //Error
}