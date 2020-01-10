package Zadanie1;

import java.sql.*;

public class TransactionDao {

    public void insert(Transaction transaction) {

        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction (type, description, amount, date) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas zapisu do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void updateTransaction(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas aktualizacji: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void deleteTransaction(Long id) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas usuwania: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public double transactionIncome() {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        Double income = 0.0;

        try {
            String sql = "SELECT SUM(amount) AS SUMA_PRZYCHODOW FROM transaction WHERE type = 'INC'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                income = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas wczytania przychodów: " + e.getMessage());
        }
        return income;
    }

    public double transactionExpenses() {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        Double expenses = 0.0;

        try {
            String sql = "SELECT SUM(amount) AS SUMA_WYDATKOW FROM transaction WHERE type='EXP'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                expenses = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas wczytania wydatków: " + e.getMessage());
        }
        return expenses;
    }


    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        try {
            return DriverManager.getConnection(url, "root", "mySql71m26w10k");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
