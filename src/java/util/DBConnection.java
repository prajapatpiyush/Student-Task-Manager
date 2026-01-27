/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author piyus
 */
public class DBConnection 
{
     private static final String URL =
        "jdbc:mysql://localhost:3306/student_task_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() 
    {
        Connection con = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_task_manager","root","root");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) 
    {
    if (getConnection() != null) 
    {
        System.out.println("DB Connected Successfully!");
    }
    }   

}
