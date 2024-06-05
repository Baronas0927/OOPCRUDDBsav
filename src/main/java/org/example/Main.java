package org.example;


import org.example.models.Author;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner sc;

    public static void main(String[] args) throws SQLException {
        Author.Start();
        sc = new Scanner(System.in);
        while (true) {
            int input = sc.nextInt();
            if (input == 0 | input > 6) {
                System.out.println("Not an option");
            }
            sc.nextLine();
            switch (input) {
                case 1:
                    Author.Start();
                    break;
                case 2:
                    Author.authorCreate();
                    Author.Start();
                    break;
                case 3:
                    System.out.println(Author.selectAll());
                    Author.Start();
                    break;
                case 4:
                    Author.authorEdit();
                    Author.Start();
                    break;
                case 5:
                    Author.authorDelete();
                    Author.Start();
                    break;
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

