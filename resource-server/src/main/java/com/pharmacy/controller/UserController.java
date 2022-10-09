package com.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.pharmacy.model.User;
import com.pharmacy.model.dto.UserDTO;
import com.pharmacy.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{email}")
    public UserDTO findUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(user);
    }

    @GetMapping()
    public List<UserDTO> findAll() {
        ArrayList<UserDTO> users = new ArrayList<>();
        userService.findAll().forEach(user -> users.add(convertToDto(user)));
        return users;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addUser(@RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        userService.createAdminUser(user);
    }

    protected UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

    protected User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
