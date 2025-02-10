package org.isdb.Model;

import java.sql.SQLException;

import java.sql.*;


public class SetBook {
        private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB"; // Service Name
        // private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCLPDB"; // SID
        private static final String USER = "orclpdbuser";
        private static final String PASSWORD = "isdb62";

        public void insertDummyData(String[][] books) {
            String insertQuery = "INSERT INTO BOOK ( title,author, price, available) VALUES (?,?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                for (String[] book : books) {
                    preparedStatement.setString(1, book[0]); // Name
                    preparedStatement.setString(2, book[1]);
                    preparedStatement.setDouble(3, Double.parseDouble(book[2]));
                    preparedStatement.setBoolean(4, Boolean.parseBoolean(book[3]));

                    preparedStatement.addBatch(); // Add to batch for batch execution
                }

                int[] rowsInserted = preparedStatement.executeBatch();
                System.out.println("Rows inserted: " + rowsInserted.length);

            } catch (SQLException e) {
                System.err.println("Error inserting data: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error processing data: " + e.getMessage());
            }
        }
    }




