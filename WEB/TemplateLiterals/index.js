const users = [
    {name:"Alice", age:53},
    {name:"Tim", age:74}
]
function generateTable(){
  

document.getElementById('tbl').innerHTML=`

    <table>
      ${users.map((user)=>{
        return `<tr>
          <td>${user.name}</td>
          <td>${user.age}</td>
        </tr>
        `
      }).join(" ")}

    </table>

`
    }

    generateTable()