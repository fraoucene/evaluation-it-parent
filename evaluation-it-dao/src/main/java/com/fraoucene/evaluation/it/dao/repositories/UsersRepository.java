package com.fraoucene.evaluation.it.dao.repositories;

import com.fraoucene.evaluation.it.api.model.Users;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fraoucene on 05/12/2015.
 */

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>, QueryDslPredicateExecutor<Users> {
}
