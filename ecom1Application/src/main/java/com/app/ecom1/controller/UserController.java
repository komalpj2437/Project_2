package com.app.ecom1.controller;

import com.app.ecom1.model.User;
//import org.apache.catalina.User;
import com.app.ecom1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    //@Autowired
    private final UserService userService;
   // private List<User> userlist=new ArrayList<User>();
   // HttpStatus
    @GetMapping("/api/users")
    public ResponseEntity <List<User>>getUsers() {
        return new ResponseEntity<> (userService.fetchAllUsers(),HttpStatus.OK);
    }
    @PostMapping("/api/users")
    public ResponseEntity <String >addUserlist(@RequestBody User user) {
         return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
    }
    @GetMapping("api/users/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable Long Id) {
      /*  User user=userService.GetUser(Id);
         if(user==null) {
             return ResponseEntity.notFound().build();
                }
         else  {
             return ResponseEntity.ok(user);
         }
         */
         return userService.GetUser(Id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/api/users/{Id}")
    public ResponseEntity <String>updatedUser(@RequestBody User user,@PathVariable Long Id) {
       Boolean success = userService.updateUser(user,Id);
       if (success) {
           return new ResponseEntity<>("Succesfully Updated", HttpStatus.OK);
            }
       return ResponseEntity.notFound().build();

        // return new  ResponseEntity<>(userService.updateUser(user,Id),HttpStatus.OK);


    }
}
