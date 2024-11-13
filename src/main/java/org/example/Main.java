package org.example;

public class Main {
    public static void main(String[] args) {
        try(var session = HibernateConfig.getSessionFactory().openSession()) {
            System.out.println("OK");
        }
    }
}