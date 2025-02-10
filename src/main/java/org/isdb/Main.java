package org.isdb;

import java.sql.*;
import org.isdb.Model.BookBook;  // Assuming this is your custom Book class

 class BookDatabase {

    // Define your DB connection details
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB"; // Service Name
     private static final String USER = "orclpdbuser";
     private static final String PASSWORD = "isdb62";

    public void addBooks(String[][] books) {
        String insertQuery = "INSERT INTO BOOK (title, author, price, available) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] book : books) {
                preparedStatement.setString(1, book[0]);  // title
                preparedStatement.setString(2, book[1]);  // author
                preparedStatement.setDouble(3, Double.parseDouble(book[2]));  // price
                preparedStatement.setBoolean(4, Boolean.parseBoolean(book[3]));  // available

                preparedStatement.addBatch();  // Add to batch for batch execution
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Create your books data (this is an example)
        String[][] books = {
                {"meme", "bithy", "500", "true"},
                {"book2", "author2", "300", "false"}
        };

        // Create an instance of BookDatabase and add books
        BookDatabase bookDatabase = new BookDatabase();
        bookDatabase.addBooks(books);
    }
}
