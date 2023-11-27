package com.bank.softway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankSoftwayApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankSoftwayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("✅ ✅");
        System.out.println();
        System.out.println("✅✅ Banco SOFTWAY iniciado com sucesso! ✅✅ ");
        System.out.println("Desenvolvido por: Danilo A. Damasceno");
        System.out.println("LinkedIn: https://www.linkedin.com/in/daniloadamasceno/");
        System.out.println("GitHub: https://github.com/DaniloADamasceno");
        System.out.println("✅ ✅");
    }
}
