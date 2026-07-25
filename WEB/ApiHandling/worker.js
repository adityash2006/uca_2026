

self.onmessage=async function (){
    console.log("Hi from worker file ")
    const a= await fetch("https://dummyjson.com/users");
    const b= await a.json();
    const ans= b.users.map((obj)=>{return {"name":obj.firstName,"status":obj.age>34}})
   
   self.postMessage(ans);
}