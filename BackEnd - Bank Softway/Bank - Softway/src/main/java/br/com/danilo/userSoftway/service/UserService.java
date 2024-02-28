package br.com.danilo.userSoftway.service;

import br.com.danilo.userSoftway.controller.records.CreateUserDto;
import br.com.danilo.userSoftway.controller.records.UpdateUserDto;
import br.com.danilo.userSoftway.entity.User;
import br.com.danilo.userSoftway.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    //! ------------------------------------------   INJECTION DEPENDENCY   --------------------------------------------
    private UserRepository userRepository;

    //! ----------------------------------------------   CONSTRUCTOR   -------------------------------------------------
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //! ----------------------------------------------   METHODS   -----------------------------------------------------
    //%% --> Criar um usuário
    public UUID createUser(CreateUserDto createUserDto) {

        // Converter de DTO pra ENTITY
        var entityConvert = new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entityConvert);

        return userSaved.getUserId();
    }

    //%% --> Buscar por ID
    public Optional<User> searchUserByID(String userId) {

        return userRepository.findById(UUID.fromString(userId));
    }

    //%% --> Listar Usuários
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    //%% --> Atualizar Usuário por ID
    public void updateUserById(String userId,
                               UpdateUserDto updateUserDto) {

        var id = UUID.fromString(userId);

        var userEntityUpdateId = userRepository.findById(id);

        if (userEntityUpdateId.isPresent()) {
            var user = userEntityUpdateId.get();

            if (updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }

            if (updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }

            userRepository.save(user);
        }
    }

    //%% --> Deletar Usuário por ID
    public void deleteById(String userDeleteId) {

        var id = UUID.fromString(userDeleteId);
        var userExists = userRepository.existsById(id);

        if (userExists) {
            userRepository.deleteById(id);
        }
    }
}
