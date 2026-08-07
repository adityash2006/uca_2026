
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

// let start = calculator(20);
// console.log(start.next("start the cal"));
// console.log(start.next("*"))
// console.log(start.next(2))
// console.log(start.next("+"))
// console.log(start.next(12))
// console.log(start.next("+"))
// console.log(start.next(8))
// console.log(start.next("/"))
// console.log(start.next(12))
// console.log(start.next("sdf"))
// console.log(start.next(1))


function *calcula(init){
    let num1 = init;
    let nextOperation = yield init;
  
    while( nextOperation != null ){
        let operator = nextOperation.operation;
        let num2 = nextOperation.value;
        
        switch(operator){
            case "add": {
                num1+=num2;
                break;
            }
            case "subtract": {
                num1-=num2;
                break;
            }
            case "divide": {
                num1/=num2;
                break;
            }
            case "multiply": {
                num1*=num2;
                break;
            }
            default :{
               throw new Error(`Unknown operator: ${operator}`);
            }
        } 
        nextOperation = yield num1;
        while( typeof nextOperation.value !='number'){
             nextOperation = yield "invalid input"
        }
    }
    
}

let calc = calcula(50);
// console.log(calc.next("start the calculator")) 
// console.log(calc.next({operation: "add", value: 30}) )
// console.log(calc.next({operation: "multiply", value: 2}) )
// console.log(calc.next({operation: "add", value: "29"})  )
// console.log(calc.next({operation: "multiply", value: 0})) 
// console.log(calc.next({operation: "add", value: 89})) 


function* fibonacci() {
    yield 0;
    let n1 = 0;
    let n2 = 1;
    yield 1;
    while(true){
        let n3 = n1 + n2;
        yield n3;
        n1 = n2;
        n2 = n3;
    }
}


const fibGen = fibonacci();

console.log(fibGen.next().value);
console.log(fibGen.next().value);
console.log(fibGen.next().value);
console.log(fibGen.next().value);
console.log(fibGen.next().value);
console.log(fibGen.next().value);














