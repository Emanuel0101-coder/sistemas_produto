package com.mercado.komprinha;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KomprinhaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KomprinhaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n🚀 Sistema Komprinha iniciado com sucesso!");
        System.out.println("👉 Acesse: http://localhost:8080/produtos");
        System.out.println("👉 Console H2: http://localhost:8080/h2-console\n");
    }
}


