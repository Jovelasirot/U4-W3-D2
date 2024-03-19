package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4W3D2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        System.out.println("Hello World!");
    }
}
