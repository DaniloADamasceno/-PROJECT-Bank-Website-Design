package com.bank.user_bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserBankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserBankApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		System.out.println("✅ ✅");
		System.out.println();
		System.out.println("✅✅ USUÁRIO iniciado com sucesso! ✅✅ ");
		System.out.println("Desenvolvido por: Danilo A. Damasceno");
		System.out.println("LinkedIn: https://www.linkedin.com/in/daniloadamasceno/");
		System.out.println("GitHub: https://github.com/DaniloADamasceno");
		System.out.println("✅ ✅");
	}
}
