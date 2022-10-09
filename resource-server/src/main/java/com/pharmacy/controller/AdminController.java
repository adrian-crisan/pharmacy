package com.pharmacy.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.pharmacy.config.admin.UserManagementService;
import com.pharmacy.config.permission.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private final UserManagementService userManagementService;

    @Secured("ROLE_ANONYMOUS")
    @PostMapping(path = "/user-claims/{uid}")
    public void setUserClaims(@PathVariable String uid, @RequestBody List<Permission> requestedClaims) throws FirebaseAuthException {
        userManagementService.setUserClaims(uid, requestedClaims);
    }
}
