package com.user.authentication.controller;

import com.user.authentication.model.User;
import com.user.authentication.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /*
    For adding new User
     */
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /*
       For updating User
   */
    @PostMapping("/updateuser/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {
        return userRepository.findById(id).map(
                usr -> {
                    usr.setName(user.getName());
                    usr.setPassword(user.getPassword());
                    return userRepository.save(usr);
                }
        ).orElseGet(() -> {
            return null;
        });
    }

    /*
     For updating or creating new User
 */
    @PutMapping("/updateorcreateuser/{id}")
    public User updateOrCreateUser(@RequestBody User user, @PathVariable Integer id) {
        return userRepository.findById(id).map(
                usr -> {
                    usr.setName(user.getName());
                    usr.setPassword(user.getPassword());
                    return userRepository.save(usr);
                }
        ).orElseGet(() -> {
            return userRepository.save(user);
        });
    }

    /*
        For getting list of Users
    */
    @GetMapping("/getuser")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    /*
        For getting single User
    */
    @GetMapping("/getuser/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    /*
        For Deleting User
   */
    @DeleteMapping("/removeuser/{id}")
    public void removeUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }


}
