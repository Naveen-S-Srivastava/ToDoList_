const taskList = document.getElementById("taskList")
const titleInput = document.getElementById("taskTitle")
const dateInput = document.getElementById("taskDate")
const addBtn = document.getElementById("addTask")

const API = "http://localhost:8080/tasks"

async function loadTasks(){

const res = await fetch(API)
const tasks = await res.json()

renderTasks(tasks)

}

function renderTasks(tasks){

taskList.innerHTML=""

tasks.forEach(task=>{

const li = document.createElement("li")

li.innerHTML = `
<div>
<strong>${task.title}</strong><br>
<small>${task.dueDate}</small>
</div>

<div>
<button onclick="deleteTask(${task.id})">Delete</button>
</div>
`

taskList.appendChild(li)

})

}

async function addTask(){

const task = {
title: titleInput.value,
dueDate: dateInput.value,
completed:false
}

await fetch(API,{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(task)
})

loadTasks()

}

async function deleteTask(id){

await fetch(API+"/"+id,{
method:"DELETE"
})

loadTasks()

}

addBtn.addEventListener("click", addTask)

loadTasks()