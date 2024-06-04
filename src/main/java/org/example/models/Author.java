package org.example.models;

import org.example.Main;

import javax.lang.model.element.Name;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.sc;

public class Author {
    private String name;
    private String surname;
    private long id;
    public Author() {
    }

    public Author(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public static void authorCreate() {
        System.out.println("Write new author name and surname: ");
        String name = sc.nextLine();
        String surname = sc.nextLine();
        System.out.println("wrote: " + name + " " + surname);
        Author.create(name, surname);
        System.out.println("Created");
    }

    public static void authorEdit() {
        System.out.println("Select authors id:");
        Author aut = findById(sc.nextInt());
        System.out.println("Write name and surname:");
        aut.setName(Main.sc.nextLine());
        aut.setSurname(Main.sc.nextLine());
        aut.update();
        System.out.println("Author edited");
    }

    public static void authorDelete() {
        System.out.println("Select authors id:");
        Author aut = findById(sc.nextInt());
        aut.delete();
        aut.update();
        System.out.println("Author deleted");
    }
    public static void Start(){
        System.out.println("-------------------------");
        System.out.println("Database");
        System.out.println("1. Show program menu");
        System.out.println("2. Insert author");
        System.out.println("3. Show authors");
        System.out.println("4. Edit authors");
        System.out.println("5. Delete authors");
        System.out.println("6. Exit program");
        System.out.println("-------------------------");
    }

    public static ArrayList selectAll() {
        ArrayList<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM authors";
        try {
            Connection con = Main.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while ((rs.next())) {
                Author aut = new Author(rs.getLong("id"), rs.getString("name"), rs.getString("surname"));
                authors.add(aut);
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("");
        }
        return authors;
    }

    public static Author findById(long id) {
        String query = "SELECT * FROM authors where id = ?";
        Author aut = null;
        try {
            Connection con = Main.connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            while ((rs.next())) {
                aut = new Author(rs.getLong("id"), rs.getString("name"), rs.getString("surname"));
            }
            con.close();
            pst.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Failed");
        }
        return aut;
    }


    public static void create(String name, String surname) {
        String query = "INSERT INTO `authors` (`name`, `surname`) VALUES (?,?)";
        try {
            Connection con = Main.connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.executeUpdate();
            con.close();
            pst.close();
        } catch (Exception E) {
            System.out.println("");
        }
    }

    public void update() {
        String query = "UPDATE `authors` SET `name`= ?, `surname` = ? WHERE id = ?";
        try {
            Connection con = Main.connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.name);
            pst.setString(2, this.surname);
            pst.setLong(3, this.id);
            pst.executeUpdate();
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("");
        }
    }

    public void delete() {
        String query = "DELETE FROM `authors` WHERE id = ?";
        try {
            Connection con = Main.connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setLong(1, this.id);
            pst.executeUpdate();
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}





