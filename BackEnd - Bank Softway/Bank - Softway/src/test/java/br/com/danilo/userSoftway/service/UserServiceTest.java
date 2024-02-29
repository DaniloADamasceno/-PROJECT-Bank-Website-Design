package br.com.danilo.userSoftway.service;

import br.com.danilo.userSoftway.controller.records.CreateUserDto;
import br.com.danilo.userSoftway.entity.User;
import br.com.danilo.userSoftway.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)    // Para o uso do Mockito no JUnit 5
class UserServiceTest {

    //! ----------------------------------------   Mocks e InjectMocks   -----------------------------------------------
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    //! ----------------------------------------   ArgumentCaptor   ----------------------------------------------------
    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;   // Capturar argumentos do tipo User

    @Captor
    private ArgumentCaptor<UUID> uuidArgumentCaptor;   // Capturar argumentos do tipo UUID

    //! ------------------------------------------------   Testes   ----------------------------------------------------

    @Nested
    class createUser {

        //%% --> Deve Criar um Usuário com Sucesso
        @Test
        @DisplayName("Deve Criar um Usuário com Sucesso")
        void shouldCreateUserWithSuccess() {

            // --> Cenário
            var UserDoReturn = new User(
                    UUID.randomUUID(),
                    "UserNAME Teste",
                    "EmailDoReturno@Teste.com",
                    "Password user doReturn",
                    Instant.now(),
                    null);

            doReturn(null).when(userRepository).save(userArgumentCaptor.capture());
            var inputTeste = new CreateUserDto(
                    "User Teste",
                    "EmailTeste@test.com",
                    "Password Teste");

            // --> Ação
            var outputShouldCreateUserWithSuccess = userService.createUser(inputTeste);

            // --> Verificação
            assertNotNull(outputShouldCreateUserWithSuccess);

            var userCaptured = userArgumentCaptor.getValue();
            assertEquals(inputTeste.username(), userCaptured.getUsername());
            assertEquals(inputTeste.email(), userCaptured.getEmail());
            assertEquals(inputTeste.password(), userCaptured.getPassword());

        }

        //%% --> Deve Lançar uma Exception quando um erro ocorrer ao criar um usuário
        @Test
        @DisplayName("Deve Lançar uma Exception quando um erro ocorrer")
        void shouldThrowExceptionWhenErrorOccurs() {

            doThrow(new RuntimeException()).when(userRepository).save(any());
            var inputTeste = new CreateUserDto(
                    "User Teste",
                    "EmailTeste@test.com",
                    "Password Teste");

            // --> Ação e Verificação
            assertThrows(RuntimeException.class, () -> userService.createUser(inputTeste));
        }
    }


    @Nested
    class searchUserByID {

        //%% --> Deve Retornar um Usuário por ID
        @Test
        @DisplayName("Deve Retornar um Usuário por ID com Sucesso com Optional Presente")
        void shouldReturnUserByIDWithSuccessWhenOptionalIsPresent() {

            // --> Cenário
            var userFindByIdDoReturn = new User(
                    UUID.randomUUID(),
                    "UserNAME Teste By ID",
                    "EmailDoReturnoByID@Teste.com",
                    "Password user doReturn By ID",
                    Instant.now(),
                    null);

            doReturn(Optional.of(userFindByIdDoReturn)).when(userRepository).findById(uuidArgumentCaptor.capture());

            var inputTesteByID = new CreateUserDto(
                    "User Teste",
                    "EmailTeste@test.com",
                    "Password Teste");

            // --> Ação
            var outputFindById = userService.searchUserByID(userFindByIdDoReturn.getUserId().toString());

            // --> Verificação
            assertTrue(outputFindById.isPresent());

            assertEquals(inputTesteByID.username(), uuidArgumentCaptor.getValue());

        }


        //%% --> Deve Retornar um Usuário por ID
        @Test
        @DisplayName("Deve Retornar um Usuário por ID com Sucesso com Optional Nulo")
        void shouldReturnUserByIDWithSuccessWhenOptionalIsNull() {

            // --> Cenário
            var userFindByIdDoReturn = new User(
                    UUID.randomUUID(),
                    "UserNAME Teste By ID",
                    "EmailDoReturnoByID@Teste.com",
                    "Password user doReturn By ID",
                    Instant.now(),
                    null);

            doReturn(Optional.empty()).when(userRepository).findById(uuidArgumentCaptor.capture());

            var inputTesteByIDEmpty = UUID.randomUUID();

            // --> Ação
            var outputFindById = userService.searchUserByID(inputTesteByIDEmpty.toString());

            // --> Verificação
            assertTrue(outputFindById.isEmpty());

            assertEquals(inputTesteByIDEmpty, uuidArgumentCaptor.getValue());

        }

    }

    @Nested
    class listAllUsers {

        @Test
        @DisplayName("Deve Listar Todos os Usuários com Sucesso")
        void shouldListAllUserWithSucess() {

            var userFindAllDoReturn = new User(
                    UUID.randomUUID(),
                    "UserNAME Teste By ID",
                    "EmailDoReturnoByID@Teste.com",
                    "Password user doReturn By ID",
                    Instant.now(),
                    null);

            var userList = List.of(userFindAllDoReturn);
            doReturn(List.of(userFindAllDoReturn)).when(userRepository).findAll();

            // --> Ação
            var outputFindAll = userService.listAllUsers();

            // --> Verificação
            assertNotNull(outputFindAll);
            assertEquals(userList.size(), outputFindAll.size());
            assertEquals(userFindAllDoReturn, outputFindAll.get(0));


        }
    }

    @Nested
    class deleteById {

        //%% --> Deletar um Usuário por ID com Sucesso
        @Test
        @DisplayName("Deve Deletar um Usuário por ID com Sucesso")
        void shouldDeleteUserByIDWithSuccess() {

            // --> Cenário
            doReturn(true).when(userRepository).existsById(uuidArgumentCaptor.capture());
            doNothing().when(userRepository).deleteById(uuidArgumentCaptor.capture());

            var userIDInput = UUID.randomUUID();
            // --> Ação
            userService.deleteById(userIDInput.toString());

            // --> Verificação
            var idList = uuidArgumentCaptor.getAllValues();                 // Captura todos os valores passados para o método
            assertEquals(userIDInput, idList.get(0));
            assertEquals(userIDInput, idList.get(1));
            assertEquals(userIDInput, uuidArgumentCaptor.getValue());

            // --> Verificação de chamadas
            verify(userRepository, times(1)).existsById(idList.get(0));
            verify(userRepository, times(1)).deleteById(idList.get(1));

        }


        //%% --> Não Deletar um Usuário por ID com Sucesso, pois ele não existe
        @Test
        @DisplayName("Não Deve Deletar um Usuário por ID com Sucesso pois ele não existe")
        void shouldNotDeleteUserWhenNotExist() {

            // --> Cenário
            doReturn(false)
                    .when(userRepository)
                    .existsById(uuidArgumentCaptor.capture());

            var userIDInput = UUID.randomUUID();

            // --> Ação
            userService.deleteById(userIDInput.toString());

            // --> Verificação
            assertEquals(userIDInput, uuidArgumentCaptor.getValue());


            // --> Verificação de chamadas
            verify(userRepository, times(1)).existsById(uuidArgumentCaptor.getValue());
            verify(userRepository, times(0)).existsById(any());

        }
    }
}