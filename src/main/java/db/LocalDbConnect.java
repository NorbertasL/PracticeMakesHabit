package db;

import data.Task;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class LocalDbConnect {
    private static final String DB_NAME = "tasks.db";
    private static String url = "jdbc:sqlite:" + DB_NAME;
    public static void createdLocalDatabase(){
        File tmpDir = new File("./"+DB_NAME);
        if(tmpDir.exists()){
            System.out.printf("The database %s exists.%n", DB_NAME);
            return;
        }
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewTable(Tables table){
        // SQL statement for creating a new table
        final String NEW_TABLE = "CREATE TABLE IF NOT EXISTS "+table.name()+" (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	task text NOT NULL,\n"
                + "	alertTime integer NOT NULL,\n"
                + " colour text NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(NEW_TABLE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertNewTask(Tables table,String task, int time, String colour) {
        final String INSERT_SQL = "INSERT INTO "+table.name()+"(task,alertTime,colour) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            if (conn != null) {
                pstmt.setString(1, task);
                pstmt.setInt(2, time);
                pstmt.setString(3, colour);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void delete(Tables table, int id){
        String sql = "DELETE FROM "+table.name() +" WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Task> getTasksList(){
        String sql = "SELECT * FROM "+ Tables.DAILY_TASKS.name();
        ArrayList<Task> returnList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                returnList.add(new Task(rs.getInt("id")
                        ,rs.getString("task")
                        , rs.getInt("alertTime")
                        , rs.getString("colour")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return returnList;
    }

    public enum Tables{
        DAILY_TASKS,
        DAILY_TASK_TRACKER

    }

}
