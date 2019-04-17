package com.jonathan.user.controller;

import com.jonathan.user.Domain.Model.User;
import com.jonathan.user.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path="/api/v1/user")
public class UserController {
    private final AddUserService addUserService;
    private final FindUserService findUserService;
    private final RemoveUserService removeUserService;
    private final UpdateUserService updateUserService;
    private final FindAllUserService findAllUserService;
    private final FindUserByIdService findUserByIdService;

    @Autowired
    public UserController(
            AddUserService addUserService,
            FindUserService findUserService,
            RemoveUserService removeUserService,
            UpdateUserService updateUserService,
            FindAllUserService findAllUserService,
            FindUserByIdService findUserByIdService
    ) {
        this.addUserService = addUserService;
        this.findUserService = findUserService;
        this.removeUserService = removeUserService;
        this.updateUserService = updateUserService;
        this.findAllUserService = findAllUserService;
        this.findUserByIdService = findUserByIdService;
    }

    @GetMapping(path="/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<CustomResponse>(
                new CustomResponse("ok", "App running"),
                HttpStatus.OK
        );
    }

    @GetMapping(path="/all")
    public ResponseEntity<?> all() {
        List<User> users = findAllUserService.execute();
        if ( users.isEmpty() ) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "users not found"),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<Iterable>(
                findAllUserService.execute(),
                HttpStatus.OK
        );
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> findUserById(
            @PathVariable(name = "id") Integer id
    ) {
        try {
            User user = findUserByIdService.execute(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "user not found"),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping(path="/add")
    public ResponseEntity<?> addNewUser(@RequestBody UserRequest userRequest) {
        User user = findUserService.execute(userRequest.getEmail());
        if (null != user) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "email already exists"),
                    HttpStatus.CONFLICT
            );
        }

        addUserService.execute(userRequest);
        return new ResponseEntity<UserRequest>(userRequest, HttpStatus.CREATED);
    }

    @PutMapping(path="/update")
    public ResponseEntity<?> updateUserByEmail(@RequestBody UserRequest userRequest) {
        String email = userRequest.getEmail();
        User user = findUserService.execute(email);
        if (null == user) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "user not found"),
                    HttpStatus.NOT_FOUND
            );
        }

        User userUpdated = updateUserService.execute(user, userRequest);

        return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
    }

    @PostMapping(path="/findByEmail")
    public ResponseEntity<?> findUserByEmail(@RequestBody Map<String, String> params) {
        String email = params.get("email");
        User user = findUserService.execute(email);
        if (null == user) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "user not found"),
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping(path="/remove")
    public ResponseEntity<?> removeUser(@RequestBody Map<String, Integer> params) {
        try {
            Integer id = params.get("id");
            removeUserService.execute(id);
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("ok", "user was deleted"),
                    HttpStatus.ACCEPTED
            );
        } catch (Exception e) {
            return new ResponseEntity<CustomResponse>(
                    new CustomResponse("error", "user not found"),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
