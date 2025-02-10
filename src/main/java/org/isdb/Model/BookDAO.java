package org.isdb.Model;

import org.isdb.Model.BookBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {


        private Connection getConnection() throws SQLException {
            return OracleConnection.getConnection();
        }

        // Create: Add new book
        public void addBooks(BookBook book) {
            String sql = "INSERT INTO BOOKS (title, author, price, available) VALUES (?, ?, ?, ?)";
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, book.getTitle());
                statement.setString(2, book.getAuthor());
                statement.setDouble(3, book.getPrice()); // Assuming price is a double
                statement.setBoolean(4, book.isAvailable()); // Assuming available is a boolean

                statement.executeUpdate(); // Execute the insert statement
            } catch (SQLException e) {
                System.err.println("Error "+e.getMessage());
            }
        }
    }


