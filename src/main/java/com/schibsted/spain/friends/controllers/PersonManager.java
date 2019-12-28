package com.schibsted.spain.friends.controllers;

import com.schibsted.spain.friends.domain.User;
import com.schibsted.spain.friends.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Handles all the internal requests to the database
 * This has to be integrated by Spring Boot.
 *
 * @author Ezequiel Martinez
 */
public class PersonManager {

    private final static Logger LOG = LoggerFactory.getLogger(PersonManager.class);

    private final PersonRepository personRepository;

    public PersonManager(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = false)
    public User save(User user) {
        User result = personRepository.save(user);
        return result;
    }

    @Transactional(readOnly = true)
    public User findByName(String name) {
        User result = personRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<User> findByTitleLike(String name) {
        Collection<User> result = personRepository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<User>  graph(int limit) {
        Collection<User> result = personRepository.getAllFriendsOf(limit);
        return result;
    }

}
