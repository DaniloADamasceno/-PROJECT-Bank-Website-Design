package br.com.danilo.userSoftway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("✅ ✅");
        System.out.println("✅✅ Bank SOFTWAY iniciada com sucesso! ✅✅ ");
        System.out.println("Desenvolvido por: Danilo A. Damasceno" + "\n");
        System.out.println("LinkedIn:                       https://www.linkedin.com/in/daniloadamasceno/");
        System.out.println("GitHub:                         https://github.com/DaniloADamasceno");
        System.out.println("Link para acesso:               http://localhost:8080/");
        System.out.println("link para acessar o SWAGGER:    http://localhost:8080/swagger-ui.html");

        System.out.println("✅ ✅");

    }
}
