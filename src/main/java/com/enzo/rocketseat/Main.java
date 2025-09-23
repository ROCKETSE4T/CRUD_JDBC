package com.enzo.rocketseat;

import com.enzo.rocketseat.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = null;
        try{
            userRepository = new UserRepository();
            userRepository.update(1, new User(null, "Mariana Vieira", "Mariana@gmail.com", null));

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (userRepository != null) {
                try {
                    //Fecha a conexão com o banco se ativa.
                    userRepository.getConnection().close();
                    System.out.println("Conexão fechada com sucesso!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

