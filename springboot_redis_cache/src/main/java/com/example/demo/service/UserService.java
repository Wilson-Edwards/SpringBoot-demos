package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User getUser(Long id);

    List<User> listUser();

    User updateUser(User user);

    void deleteUser(Long id);
}
