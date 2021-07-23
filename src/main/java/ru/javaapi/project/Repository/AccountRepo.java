package ru.javaapi.project.Repository;

import ru.javaapi.project.DbConnection.DbConnection;
import ru.javaapi.project.Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepo {

    public Account findAccountByLogin(String login) {
        Account account = new Account();

        // экономим место, закрываем соединение Connection и PreparedStatement "одним махом".
        try(Connection connection = new DbConnection().dbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select login, lastname from users where login = ?")) {

            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account.setLogin(resultSet.getString("login"));
                account.setLastName(resultSet.getString("lastname"));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        if (account.getLogin() == null) {
            return null;
        }
        return account;
    }

    public void editAccountInfo(String login, String newLastName) {
        try(Connection connection = new DbConnection().dbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update users set lastname = ? where login = ?")) {

            preparedStatement.setString(1, newLastName);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
