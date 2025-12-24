package com.app.ecom1.service;

import com.app.ecom1.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private long x=1L;
    private List<User> userlist=new ArrayList<>();

    @Override
    public Optional<User> GetUser(Long id) {

        return userlist.stream().filter(user -> user.getId()==id).findFirst();
    }


    @Override
    public List<User> fetchAllUsers() {
        return userlist;
    }

    @Override
    public boolean updateUser(User u, Long id) {
        return userlist.stream()
                .filter(a -> a.getId()==(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstname(u.getFirstname());
                    existingUser.setLastname(u.getLastname());
                    // update fields as needed
                    return true;
                })
                .orElse(false);
    }


    @Override
    public  String createUser(User user) {
        user.setId(x++);
        userlist.add(user);
        return "User created successfully";
    }
}
