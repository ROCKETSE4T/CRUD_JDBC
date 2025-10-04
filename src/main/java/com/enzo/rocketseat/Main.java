package com.enzo.rocketseat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
//        UserRepository userRepository = null;
//        try{
//            userRepository = new UserRepository();
//            userRepository.update(1, new User(null, "Mariana Vieira", "Mariana@gmail.com", null));
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            if (userRepository != null) {
//                try {
//                    //Fecha a conexão com o banco se ativa.
//                    userRepository.getConnection().close();
//                    System.out.println("Conexão fechada com sucesso!");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        // UTILIZANDO JPA + HIBERNATE
        try {
            // Inicializa o ORM Hibernate, puxando as configuracões da UNidade de persistência definida no meu persistence.xml
            // Aqui o Hibernate faz o mapeamento das entidades, criando o metamodelo.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

            //Logica para gerenciar as entidades
            //Feita a partir dos metadados que o Hibernate gerou.
            EntityManager em = emf.createEntityManager();
            User user = new User(null, "Mariana Vieira", "Mariana@gmail.com", null);


           //Inicia a transação com o banco de dados
            em.getTransaction().begin();


            //Salva o usuário
            em.persist(user);

            em.getTransaction().commit();


            //Liberação de recursos;
            //Fecha pools de conexão e etc.
            emf.close();
            em.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

