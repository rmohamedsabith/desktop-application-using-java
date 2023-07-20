/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

/**
 *
 * @author Riyaz
 */
public class DbConnection {
    private final String drive_class = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/holidayhelper";
    private final String username = "root";
    private final String password = "";

    public String getDrive_class() {
        return drive_class;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    

    
}
