package com.springsecurity.service;

import com.springsecurity.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User("USR0001", "timoba", "Timo", "Ball", "noonettplayer"));
        userList.add(new User("USR0002", "malo", "Ma", "Long", "notwottplayer"));
        userList.add(new User("USR0003", "dima", "Dimitriv", "Chikarow", "nothreettplayer"));
        userList.add(new User("USR0004", "xu", "Xu", "Xin", "nofourttplayer"));
        userList.add(new User("USR0005", "hari", "Tomakazu", "Harimoto", "nofivettplayer"));
    }

    public List<User> getAllUsers() {
        return this.userList;
    }

    public User getUserById(String userId) {
        return this.userList.stream().filter((user) -> user.getUserId().equalsIgnoreCase(userId)).findAny().get();
    }

    public User createNewUser(User user) {
        this.userList.add(user);
        return user;
    }

    public User updateUser(User updatedUser) {
        User oldUser = this.userList.stream().filter((user) -> user.getUserId().equalsIgnoreCase(updatedUser.getUserId())).findAny().get();
        this.userList.remove(oldUser);
        this.userList.add(updatedUser);
        return oldUser;
    }

    public String deleteUser(String userId) {
        User user1 = this.userList.stream().filter((user) -> user.getUserId().equalsIgnoreCase(userId)).findAny().get();
        this.userList.remove(user1);
        return "User has been removed!";
    }

}
