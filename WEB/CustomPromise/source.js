

// function executorFunction(resolve, reject){

//     let checker = false;
//     setTimeout(()=>{
//         console.log("SOMEthing is cooking eh");

//         if(checker){
//         console.log("LEts resolve this promise ");
//         resolve("defined truee ")   
//         } 
//         else reject("defined false");
//     },2000);

// }

// function NewPromise(executorFunction) {
    
//     this.state = "pending";

//     let successCallBack = (value)=>{
//         console.log("default success with", value);
//     }
//     let errorCallBack = (value)=>{
//         console.log("default error with",value);
//     }

//     this.then = function(userSuccessCallback){
//         successCallBack = userSuccessCallback;
//     }

//     this.catch = function(userSuccessCallback){
//         errorCallBack = userSuccessCallback;
//     }

//     executorFunction((value)=>{
//         this.state="fullfilled";
//         successCallBack(value);
//     },(value)=>{
//         this.state="rejected";
//         errorCallBack(value);
//     });

// }

//     const p1 = new NewPromise(executorFunction);

// p1.then((val)=>{
//     console.log("Custom successcallback",val)
// })



function NewPromise(executorFunction) {

    this.state = "pending";
   let successCallBack = null;
    let errorCallBack = null;

    this.then = function(userSuccessCallback) {

        return new NewPromise((resolve, reject) => {

            successCallBack = (value) => {

                let result = userSuccessCallback(value);

                resolve(result);
            };

            errorCallBack = reject;
        });
    };

    this.catch = function(userErrorCallback) {

        errorCallBack = userErrorCallback;
    };

    executorFunction(
        (value) => {
            this.state = "fulfilled";

            if (successCallBack) {
                successCallBack(value);
            }
        },

        (value) => {
            this.state = "rejected";

            if (errorCallBack) {
                errorCallBack(value);
            }
        }
    );}


new NewPromise(resolve => {
    setTimeout(() => {
        resolve(5);
    }, 1000);
})
.then(value => {
    return value * 2;
})
.then(value => {
    return value * 5;
})
.then(value => {
    console.log(value);
});
