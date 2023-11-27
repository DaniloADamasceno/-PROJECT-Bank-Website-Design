package com.bank.softway.services;

import com.bank.softway.entities.User;

public interface ServiceInterfaceUser {

    User Save(User user);                       // Salvar um usuário

    // * BUSCAS
    User findByEmail(String email);             // Buscar um usuário pelo email
    User findById(Long id);                     // Buscar um usuário pelo id
    void deleteById(Long id);                   // Deletar um usuário pelo id
    User findAllServiceAccount(Long id);        // Buscar todas as contas de um usuário pelo id


    // * ATUALIZAÇÕES
    User update(Long id, User user);            // Atualizar um usuário pelo id
    User updateEmail(Long id, String email);    // Atualizar o email de um usuário pelo id
    User updateName(Long id, String name);      // Atualizar o nome de um usuário pelo id
    User updateLastName(Long id, String lastName); // Atualizar o sobrenome de um usuário pelo id
    User updatePassword(Long id, String password); // Atualizar a senha de um usuário pelo id
    User updateBirthDate(Long id, String birthDate); // Atualizar a data de nascimento de um usuário pelo id

    // * ATUALIZAÇÕES DE ENDEREÇO
    User updateCep(Long id, String cep);        // Atualizar o cep de um usuário pelo id
    User updateAddress(Long id, String street);  // Atualizar a rua de um usuário pelo id
    User updateCountry(Long id, String country);// Atualizar o país de um usuário pelo id

    // * ATUALIZAÇÕES DE PERFIL
    User updateProfile(Long id, String profile); // Atualizar o perfil de um usuário pelo id
}
