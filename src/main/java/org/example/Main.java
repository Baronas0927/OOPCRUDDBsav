package org.example;



import org.example.models.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(Author.selectAll());
        Author a = Author.findById(8);
        System.out.println(a);
        a.setName("luksas");
        a.setSurname("luksinis");
        a.setId(4);
        a.update();
        System.out.println(a);

    }
    public static Connection connect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        }catch (Exception e){
            System.out.println("Failed to connect db");
        }
        return connection;
    }
}

