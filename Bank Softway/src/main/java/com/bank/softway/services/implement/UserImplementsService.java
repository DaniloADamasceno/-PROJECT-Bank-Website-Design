package com.bank.softway.services.implement;

import com.bank.softway.entities.User;
import com.bank.softway.repository.RepositoryInterfaceUser;
import com.bank.softway.services.ServiceInterfaceUser;

public class UserImplementsService implements ServiceInterfaceUser {

    //? ------------------------------------------   INJECTION DEPENDENCY   --------------------------------------------
    private final RepositoryInterfaceUser repositoryInterfaceUser;

    //? ------------------------------------------   CONSTRUCTOR   -----------------------------------------------------
    public UserImplementsService(RepositoryInterfaceUser repositoryInterfaceUser) {
        this.repositoryInterfaceUser = repositoryInterfaceUser;
    }

    //? ------------------------------------------   METHODS   ---------------------------------------------------------

    //#! SAVE USERs
    @Override
    public User Save(User user) {
        return null;
    }

    // #! FIND BY EMAIL
    @Override
    public User findByEmail(String email) {
        return null;
    }

    // #! FIND BY ID
    @Override
    public User findById(Long id) {
        return null;
    }

    // #! DELETE BY ID
    @Override
    public void deleteById(Long id) {
    }

    // #! FIND ALL SERVICE ACCOUNT
    @Override
    public User findAllServiceAccount(Long id) {
        return null;
    }

    // #! UPDATE
    @Override
    public User update(Long id, User user) {
        return null;
    }

    // #! UPDATE EMAIL
    @Override
    public User updateEmail(Long id, String email) {
        return null;
    }

    // #! UPDATE NAME
    @Override
    public User updateName(Long id, String name) {
        return null;
    }

    // #! UPDATE LAST NAME
    @Override
    public User updateLastName(Long id, String lastName) {
        return null;
    }

    // #! UPDATE PASSWORD
    @Override
    public User updatePassword(Long id, String password) {
        return null;
    }

    // #! UPDATE BIRTH DATE
    @Override
    public User updateBirthDate(Long id, String birthDate) {
        return null;
    }

    // #! UPDATE CEP
    @Override
    public User updateCep(Long id, String cep) {
        return null;
    }

    // #! UPDATE ADDRESS
    @Override
    public User updateAddress(Long id, String street) {
        return null;
    }

    // #! UPDATE COUNTRY
    @Override
    public User updateCountry(Long id, String country) {
        return null;
    }

    // #! UPDATE PROFILE
    @Override
    public User updateProfile(Long id, String profile) {
        return null;
    }
}
