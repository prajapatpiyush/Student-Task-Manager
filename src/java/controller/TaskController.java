package controller;

import model.Task;
import model.TaskDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/task")
public class TaskController extends HttpServlet 
{

    private TaskDAO dao;

    @Override
    public void init()
    {
        dao = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        List<Task> tasks = dao.getAllTasks();

        out.print("[");
        for (int i = 0; i < tasks.size(); i++) 
        {
            Task t = tasks.get(i);
            out.print("{");
            out.print("\"id\":" + t.getId() + ",");
            out.print("\"title\":\"" + t.getTitle() + "\",");
            out.print("\"status\":\"" + t.getStatus() + "\",");
            out.print("\"createdAt\":\"" + t.getCreatedAt() + "\"");
            out.print("}");
            if (i < tasks.size() - 1) out.print(",");
        }
        out.print("]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException 
    {

        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();

        if ("update".equals(action))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            String status = req.getParameter("status");
            out.print(dao.updateStatus(id, status) ? "SUCCESS" : "FAIL");
            return;
        }

        if ("delete".equals(action))
        {
            int id = Integer.parseInt(req.getParameter("id"));
            out.print(dao.deleteTask(id) ? "SUCCESS" : "FAIL");
            return;
        }

        // ADD TASK
        String title = req.getParameter("title");
        if (title == null || title.trim().isEmpty()) 
        {
            out.print("INVALID");
            return;
        }

        out.print(dao.addTask(new Task(title)) ? "SUCCESS" : "FAIL");
    }
}
