package org.example;


import org.example.models.Author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static void main(String[] args) throws SQLException {
        System.out.println("-------------------------");
        System.out.println("Database");
        System.out.println("1. Insert author");
        System.out.println("2. Show authors");
        System.out.println("3. Edit authors");
        System.out.println("4. Delete authors");
        System.out.println("5. Exit program");
        System.out.println("-------------------------");
        sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        while (true) {
            switch (input) {
                case 1:
                    Author.authorCreate();
                case 2:
                    System.out.println(Author.selectAll());
                case 3:

                case 4:
                case 5:
                    System.exit(1);
            }
        }
//        System.out.println(Author.selectAll());
//        Author a = Author.findById(8);
//        System.out.println(a);
//
//
//        a.setSurname("luksinis");
//        a.setId(4);
//        a.update();
//        System.out.println(a);

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

