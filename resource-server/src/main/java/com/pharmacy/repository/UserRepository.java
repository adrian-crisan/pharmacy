package com.pharmacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.pharmacy.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
