
function *calculator(init){
    let num1 = init;
    let operator = yield "begin";
    
    while( operator != "done" ){
        let num2 = yield num1;
        switch(operator){
            case "+": {
                num1+=num2;
                break;
            }
            case "-": {
                num1-=num2;
                break;
            }
            case "/": {
                num1/=num2;
                break;
            }
            case "*": {
                num1*=num2;
                break;
            }
            default :{
               throw new Error(`Unknown operator: ${operator}`);
            }
        } 
        operator = yield num1;
    }

    return num1;
}

let start = calculator(20);
console.log(start.next("start the cal"));
console.log(start.next("*"))
console.log(start.next(2))
console.log(start.next("+"))
console.log(start.next(12))
console.log(start.next("+"))
console.log(start.next(8))
console.log(start.next("/"))
console.log(start.next(12))
console.log(start.next("sdf"))
console.log(start.next(1))














