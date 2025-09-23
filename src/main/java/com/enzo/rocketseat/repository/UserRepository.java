package com.enzo.rocketseat.repository;

import com.enzo.rocketseat.DBConnection;
import com.enzo.rocketseat.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository  {
    private Connection connection;

    public UserRepository() throws SQLException{
        try {
            connection = DBConnection.getInstance().getDbConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void create(String name, String email) throws SQLException{
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        // Adiciona o nome na query;
        stmt.setString(1, name);

        //Adiciona o email na query;
        stmt.setString(2, email);

        stmt.execute();
        stmt.close();

    }

    public void update(Integer id, User userAtt) throws SQLException{
        User user = findById(id);
        String name = userAtt.getName() != null ? userAtt.getName() : user.getName();
        String email = userAtt.getEmail() != null ? userAtt.getEmail() : user.getEmail();

        String sql = "UPDATE users SET name = ? , email = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        // Adiciona o nome na query;
        stmt.setString(1, name);

        //Adiciona o email na query;
        stmt.setString(2, email);

        //Adiciona o id na query;
        stmt.setLong(3, id);

        stmt.execute();
        stmt.close();

    }

    public void delete(Integer id) throws SQLException{
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public ArrayList<User> findAll() throws SQLException{
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            User user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"), rs.getDate("created_at"));
            users.add(user);
        }

        stmt.close();
        rs.close();

        return users;

    }

    public User findById(Integer id) throws SQLException{
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            user = new User(rs.getLong("id"), rs.getString("name"), rs.getString("email"), rs.getDate("created_at"));
        }

        stmt.close();
        rs.close();
        return user;

    }


}
