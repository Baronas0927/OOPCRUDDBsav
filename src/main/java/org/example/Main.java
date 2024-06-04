package org.example;


import org.example.models.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static void main(String[] args) throws SQLException {
        Author.Start();
        sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        while (true) {
            switch (input) {
                case 1:
                    Author.Start();
                    break;
                case 2:
                    Author.authorCreate();
                    break;
                case 3:
                    System.out.println(Author.selectAll());
                    break;
                case 4:
                    Author.authorEdit();
                    break;
                case 5:
                    Author.authorDelete();
                case 6:
                    System.exit(1);
            }
        }

    }

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        } catch (Exception e) {
            System.out.println("Failed to connect database");
        }
        return connection;
    }


}

