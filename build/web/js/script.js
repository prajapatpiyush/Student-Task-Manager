/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

window.onload = loadTasks;

function addTask() 
{
    let task = taskInput.value.trim();
    if (task === "")
    {
        alert("Task cannot be empty");
        return;
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "task", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onload = loadTasks;
    xhr.send("title=" + encodeURIComponent(task));
    taskInput.value = "";
}

function loadTasks() 
{
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "task", true);

    xhr.onload = function ()
    {
        let tasks = JSON.parse(xhr.responseText);
        taskList.innerHTML = "";

        tasks.forEach(t => 
        {

            // Convert timestamp to readable format
            let date = new Date(t.createdAt);
            let formattedTime = date.toLocaleString();

            let li = document.createElement("li");
            li.innerHTML = `
                <input type="checkbox"
                    ${t.status === "COMPLETED" ? "checked" : ""}
                    onchange="updateStatus(${t.id}, this.checked)">

                <div class="task-content">
                    <span class="${t.status === "COMPLETED" ? "done" : ""}">
                        ${t.title}
                    </span>
                    <small class="timestamp">
                        Added on: ${formattedTime}
                    </small>
                </div>

                <button class="delete-btn"
                    onclick="deleteTask(${t.id})">X</button>
            `;
            taskList.appendChild(li);
        });
    };

    xhr.send();
}

function updateStatus(id, checked) 
{
    let status = checked ? "COMPLETED" : "PENDING";
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "task", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onload = loadTasks;
    xhr.send("action=update&id=" + id + "&status=" + status);
}

function deleteTask(id) 
{
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "task", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onload = loadTasks;
    xhr.send("action=delete&id=" + id);
}
