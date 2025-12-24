package com.app.ecom1.service;

import com.app.ecom1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> fetchAllUsers();
    public String createUser(User user);
    public Optional<User> GetUser(Long Id);
    public boolean updateUser(User u,Long id);



}
