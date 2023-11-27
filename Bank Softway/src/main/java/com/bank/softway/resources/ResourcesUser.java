package com.bank.softway.resources;

import com.bank.softway.entities.User;
import com.bank.softway.repository.RepositoryInterfaceUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

public class ResourcesUser {


    private static final Logger logger = LoggerFactory.getLogger(ResourcesUser.class); //--> para imprimir no console

    //? --------------------------------------------   INJECTION DEPENDENCY  -------------------------------------------
    private final RepositoryInterfaceUser repositoryInterfaceUser;
    private final Environment environment;

    //? ----------------------------------------------   CONSTRUCTOR   -------------------------------------------------
    public ResourcesUser(RepositoryInterfaceUser repositoryInterfaceUser, Environment environment) {
        this.repositoryInterfaceUser = repositoryInterfaceUser;
        this.environment = environment;
    }

    //? --------------------------------------------   Methods -> End-Points  ------------------------------------------

    //FIND ALL BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<List> findAllById(@PathVariable Long id) {
        List<User> ProductTest;
        ProductTest = productService.findAllById(id);
        return ResponseEntity.ok().body(productRepository.findAllById(Collections.singleton(id)));
    }

    //FIND BY ID
    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id) {                   //  --> Busca por ID
        logger.info("PORT / PORTA = " + environment.getProperty("local.server.port"));  //--> para imprimir no console
        User userFindById = repositoryInterfaceUser.findById(id).get();
        return ResponseEntity.ok(userFindById);
    }

    //FIND BY EMAIL
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {               //  --> Busca por EMAIL
        logger.info("PORT / PORTA = " + environment.getProperty("local.server.port"));  //--> para imprimir no console
        User userFindByEmail = repositoryInterfaceUser.findByEmail(email);
        return ResponseEntity.ok(userFindByEmail);
    }

}