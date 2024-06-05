package org.example.models;

import org.example.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.Main.sc;

public class Book {
    private long authorid;
    private String author;
    private String title;

    public static void bookStart() {
        System.out.println("-------------------------");
        System.out.println("Database");
        System.out.println("1. Show books menu");
        System.out.println("2. Insert book");
        System.out.println("3. Show books");
        System.out.println("4. Edit books");
        System.out.println("5. Delete books");
        System.out.println("6. Exit program");
        System.out.println("-------------------------");
    }

    public static void consoleBooks() {
        System.out.println("Welcome to books console!!!");
        bookStart();
        int input = sc.nextInt();
        while (true) {
            if (input == 0 | input > 6) {
                System.out.println("Not an option");
            }
            sc.nextLine();
            switch (input) {
                case 1:
                    selectAll();
                    bookStart();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }

    }

    public static ArrayList selectAll() {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try {
            Connection con1 = Main.connect();
            Statement stmt1 = con1.createStatement();
            ResultSet rs = stmt1.executeQuery(query);
            while ((rs.next())) {
                Book buk = new Book(rs.getLong("author id"), rs.getString("author"), rs.getString("genre"));
                books.add(buk);
            }
            con1.close();
            stmt1.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("");
        }
        return books;
    }

    public static void insertBook() {
        System.out.println("authors id");
        Long authorId = sc.nextLong();
        if (!authorId.equals("")) {
            System.out.println("Wrong id");
        } else {
            System.out.println("Given id: " + authorId);
        }
        System.out.println("Books title");
        String title = sc.nextLine();
        if (!title.equals("")) {
            System.out.println("Wrong title");
        } else {
            System.out.println("Given title: " + title);
        }
        System.out.println("books genre");
        String genre = sc.nextLine();
        if (!genre.equals("")) {
            System.out.println("Wrong genre");
        } else {
            System.out.println("Given genre: " + genre);
        }

    }
    public static void create(Long authorid, String author, String genre) {
        String query = "INSERT INTO `books` (`author`, `genre`) VALUES (?,?)";
        try {
            Connection con = Main.connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, authorid);
            pst.setString(2, author);
            pst.setString(3, genre);
            pst.executeUpdate();
            con.close();
            pst.close();
        } catch (Exception E) {
            System.out.println("");
        }
    }


    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(long authorId, String author, String genre) {
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorid=" + authorid +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}






