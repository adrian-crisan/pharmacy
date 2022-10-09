package com.pharmacy.service;

import com.pharmacy.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByEmail(String email);

    Iterable<User> findAll();

    User createAdminUser(User user);
}
