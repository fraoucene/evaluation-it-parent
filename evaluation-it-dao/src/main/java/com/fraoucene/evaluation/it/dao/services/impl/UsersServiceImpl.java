package com.fraoucene.evaluation.it.dao.services.impl;

import com.fraoucene.evaluation.it.api.model.Users;
import com.fraoucene.evaluation.it.api.services.UsersService;
import com.fraoucene.evaluation.it.dao.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fraoucene on 05/12/2015.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void createUser(Users aUser) {
        usersRepository.save(aUser);
        LOGGER.warn("---- Count Categories records:  {}", usersRepository.count());
    }

    @Override
    public boolean isUser(Long id) {
        return usersRepository.exists(id);
    }

    @Override
    public Users getUser(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public Iterable<Users> getAllUsers() {
        Iterable<Users> allUsers = usersRepository.findAll();
        return allUsers;
    }

    @Override
    public void updateUser(Users aUser) {
        Users user = usersRepository.findOne(aUser.getUserId());
        usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.delete(id);
        LOGGER.warn("---- Count Categories records:  {}", usersRepository.count());
    }
}
