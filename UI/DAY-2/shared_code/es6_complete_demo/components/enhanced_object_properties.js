

export function testComputedPropertyName() {

    var oId = 111;
    var oTitle = 'My order';
    var _orderObj = { id: oId, 
                      title: oTitle,
                    getTitle: function() { return this.title; }
                }; //ES5
            
    var _orderObj_es6 = { id: oId, 
        title: oTitle,
        getTitle() { return this.title; }
    }; //ES6

              var myTitle = _orderObj.getTitle();




    let idKey = 'id';
    let titleKey = 'title';
    let _orderObj_2 = { [idKey]: oId, [titleKey]: oTitle}; //ES6
    let accountObj = { accId: 444 };




    //var titleKey = 'title';
    var orderObj = { id: 111, [titleKey]: 'My order'};
    console.log("orderObj.titleKey", orderObj.titleKey);
    console.log("orderObj.title", orderObj.title);

}







export function testMethodProperties() {
    var orderObj = { id: 111, title: 'My order',
                printOrder: function() {
                    console.log(this.id,' - ', this.title);
                }
            };

    let orderObj_2 = { id: 222, title: 'Your order',
                printOrder() {
                    console.log(this.id,' - ', this.title);
                }
            };

orderObj.printOrder(); 
orderObj_2.printOrder(); 
}

export function testCopyProperties() {
    var orderObj = { id: 111, title: 'My order'};
    var orderObj_2 = { rollNo: 222, name: 'My order name'};
    var targetOrderObj = {company: 'Oracle'};

    let newOrderObj = Object.assign(targetOrderObj, orderObj, orderObj_2);
    console.log("targetOrderObj", targetOrderObj);
    console.log("newOrderObj", newOrderObj);
}