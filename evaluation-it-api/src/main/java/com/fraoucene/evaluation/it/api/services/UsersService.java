package com.fraoucene.evaluation.it.api.services;

import com.fraoucene.evaluation.it.api.model.Users;

/**
 * Created by fraoucene on 05/12/2015.
 */
public interface UsersService {

    void createUser(Users aUser);

    boolean isUser(Long id);

    Users getUser(Long id);

    Iterable<Users> getAllUsers();

    void updateUser(Users aUser);

    void deleteUser(Long id);
}
