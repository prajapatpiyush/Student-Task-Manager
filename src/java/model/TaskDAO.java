/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.DBConnection;
import java.sql.*;
import java.util.*;

public class TaskDAO 
{

    // ADD TASK
    public boolean addTask(Task task)
    {
        String sql = "INSERT INTO tasks (title) VALUES (?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setString(1, task.getTitle());
            return ps.executeUpdate() > 0;

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    // GET ALL TASKS
    public List<Task> getAllTasks() 
    {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {

            while (rs.next()) 
            {
                Task t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setStatus(rs.getString("status"));
                t.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(t);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE STATUS
    public boolean updateStatus(int id, String status) 
    {
        String sql = "UPDATE tasks SET status=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE TASK
    public boolean deleteTask(int id)
    {
        String sql = "DELETE FROM tasks WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
