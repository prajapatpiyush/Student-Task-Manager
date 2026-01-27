<%-- 
    Document   : index
    Created on : 27 Jan 2026, 9:59:55?pm
    Author     : piyus
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Task Manager</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header>
    <h1>Student Task Manager</h1>
    <p class="subtitle">
        Assignment for <strong>Zimetrics Technologies</strong> - Assessment Round
    </p>
</header>

<section class="info">
    <p>
        This web application is designed to help students manage and track
        their academic tasks efficiently using a simple and clean interface.
    </p>
</section>

<div class="container">
    <input type="text" id="taskInput" placeholder="Enter task">
    <button onclick="addTask()">Add</button>

    <ul id="taskList"></ul>
</div>

<footer>
    <p>
        Developed by <strong>Piyush Prajapati</strong><br>
        Java Developer | Java MVC | MySQL | AJAX
    </p>
</footer>

<script src="js/script.js"></script>
</body>
</html>
