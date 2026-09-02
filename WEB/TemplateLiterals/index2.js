const fields = [ 
  "First Name", 
  "Last Name", 
  "Email"
]; 

function generateForm(){
  

document.getElementById('tbl').innerHTML=`

   
      ${fields.map((user)=>{
        return `<div><label> ${user}</label>
          
          <input type="text" for>
        </div>
        `
      }).join(" ")}
`
    }

generateForm()