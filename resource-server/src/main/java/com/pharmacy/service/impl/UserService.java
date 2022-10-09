package com.pharmacy.service.impl;

import com.pharmacy.model.Address;
import com.pharmacy.model.User;
import com.pharmacy.repository.AddressRepository;
import com.pharmacy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pharmacy.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createAdminUser(User user) {
        User userToAdd = new User();
        Address address = addressRepository.findById(1).get();

        userToAdd.setAddress(address);
        userToAdd.setEmail(user.getEmail());
        userToAdd.setName(user.getName());
        userToAdd.setRole(user.getRole());
        userToAdd.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        address.addUser(userToAdd);

        return userRepository.save(userToAdd);
    }
}
