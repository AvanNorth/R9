package ru.itis.servletsapp.services;

import ru.itis.servletsapp.dto.UserDto;
import ru.itis.servletsapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    List<User> getUserFriends(Long id);
}
