package br.com.danilo.userSoftway.controller;

import br.com.danilo.userSoftway.controller.records.CreateUserDto;
import br.com.danilo.userSoftway.controller.records.UpdateUserDto;
import br.com.danilo.userSoftway.entity.User;
import br.com.danilo.userSoftway.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    //! ----------------------------------------  Dependency Injection  ------------------------------------------------
    private UserService userServiceController;

    //! ------------------------------------------  Constructors  ------------------------------------------------------
    public UserController(UserService userService) {
        this.userServiceController = userService;
    }

    //! -----------------------------------------------  Methods  ------------------------------------------------------

    //%%  --> Criar Usuário
    @PostMapping
    @Operation(summary = "Criar Usuário", description = "Cria um novo usuário no sistema.")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userServiceController.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }

    //%%  --> Buscar por ID
    @GetMapping("/{userId}")
    @Operation(summary = "Buscar por ID", description = "Busca um usuário pelo ID.")
    public ResponseEntity<User> findUserById(@PathVariable("userId") String userId) {
        var controllerUserById = userServiceController.searchUserByID(userId);

        if (controllerUserById.isPresent()) {
            return ResponseEntity.ok(controllerUserById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //%%  --> Listar Usuários
    @GetMapping
    @Operation(summary = "Listar Usuários", description = "Lista todos os usuários cadastrados no sistema.")
    public ResponseEntity<List<User>> listUsers() {
        var userList = userServiceController.listAllUsers();

        return ResponseEntity.ok(userList);
    }

    //%%  --> Atualizar Usuário
    @PutMapping("/{userId}")
    @Operation(summary = "Atualizar Usuário", description = "Atualiza um usuário pelo ID.")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                               @RequestBody UpdateUserDto updateUserDto) {
        userServiceController.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    //%%  --> Deletar Usuário
    @DeleteMapping("/{userId}")
    @Operation(summary = "Deletar Usuário", description = "Deleta um usuário pelo ID.")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId) {
        userServiceController.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}


