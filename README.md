# Student Task Manager

## Assignment for Zimetrics Technologies – Assessment Round

The **Student Task Manager** is a simple Single Page Application (SPA) developed to help students manage and track their academic tasks efficiently.  
This project demonstrates **full-stack web development using Java MVC architecture**, **MySQL database integration**, and **AJAX-based dynamic UI updates**, without using any external APIs or frameworks.

---

##  Tech Stack

- **Frontend:** JSP, HTML, CSS, Vanilla JavaScript (AJAX)
- **Backend:** Java (Servlets, MVC Architecture)
- **Database:** MySQL (Relational database used for persistent task storage)
- **Server:** Apache Tomcat
- **IDE:** NetBeans

---

##  Features

### Core Features
- Add a new task without page refresh (SPA behavior)
- View all tasks dynamically
- Persistent task storage using MySQL database

### Extra Features
- Mark tasks as **Completed**
- Delete tasks (red delete button for better UX)
- Display task creation **timestamp**
- Clean and modern UI with proper alignment for long and short task names
- Static content showing assignment details and developer information

---

##  Database Design (MySQL)

The application uses a **MySQL relational database** to ensure data persistence and reliability.

### Table: `tasks`
- `id` – Primary Key (Auto Increment)
- `title` – Task description
- `status` – Task state (`PENDING` / `COMPLETED`)
- `created_at` – Timestamp of task creation

The schema is intentionally kept simple to support efficient CRUD operations and easy scalability.

---

##  How I Thought (Design & Approach)

I started by analyzing the problem statement and breaking it down into functional and non-functional requirements.  
To ensure permanent data storage and real-world backend integration, I chose **MySQL** as the database and connected it using **JDBC**.

The project follows the **MVC (Model-View-Controller)** architecture:

- **Model Layer:**  
  Represents the `Task` entity and handles all MySQL database operations using JDBC and the DAO pattern.  
  All SQL queries are isolated in the DAO layer for maintainability and security.

- **Controller Layer:**  
  A servlet that acts as a single entry point to handle task-related actions such as add, list, update status, and delete.

- **View Layer:**  
  JSP is used only for UI rendering, while JavaScript (AJAX) is used to communicate with the backend and update the UI dynamically without refreshing the page.

External libraries and APIs were intentionally avoided to strictly comply with the assessment requirements and to demonstrate strong fundamentals.

---

##  Challenges Faced

- **MySQL schema mismatch issue:**  
  Initially encountered an error due to incorrect database selection in the JDBC configuration, causing table resolution failures.  
  This was resolved by aligning the JDBC URL with the correct MySQL schema and verifying the table structure manually.

- **Implementing SPA behavior without frameworks:**  
  Achieved dynamic UI updates using vanilla JavaScript and `XMLHttpRequest`.

- **UI alignment issues:**  
  Solved layout problems for long and short task names using CSS Grid and fixed-size action buttons.

- **CSS specificity conflict:**  
  Resolved delete button color override by introducing semantic class-based styling.

---


##  Screenshot Proof
<img width="1915" height="867" alt="Screenshot 2026-01-27 231030" src="https://github.com/user-attachments/assets/62915adb-ae9c-4265-91e7-d68d86963579" />

The submission includes a screenshot showing:
- Three tasks added
- One task marked as completed
- Visible timestamps
- Red delete button
- Clean and aligned UI
- Assignment heading and developer details

---

##  Project Structure

```text
StudentTaskManager
├── Source Packages
│   ├── model
│   │   ├── Task.java          # Task entity class
│   │   └── TaskDAO.java       # Data Access Object for Task operations
│   ├── controller
│   │   └── TaskController.java # Servlet/Controller to handle requests
│   └── util
│       └── DBConnection.java  # Database connection utility
├── Web Pages
│   ├── index.jsp              # Main user interface
│   ├── css
│   │   └── style.css          # Frontend styling
│   └── js
│       └── script.js          # Client-side validation/logic
└── README.md                  # Project documentation

```

##  Developed By

**Piyush Prajapati**  
Java Developer  
Java MVC | MySQL | AJAX

---

##  Conclusion

This project fulfills all the requirements of the assessment while also showcasing additional features, clean architecture, and attention to detail.  
It reflects my understanding of **Java MVC design**, **MySQL database integration**, **AJAX-based SPA development**, and real-world debugging practices.
