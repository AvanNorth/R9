package ru.itis.servletsapp.services.impl;

import ru.itis.servletsapp.dao.PostsRepository;
import ru.itis.servletsapp.dao.UsersRepository;
import ru.itis.servletsapp.dto.UserDto;
import ru.itis.servletsapp.exceptions.NotFoundException;
import ru.itis.servletsapp.model.User;
import ru.itis.servletsapp.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional= usersRepository.findById(id);
        return userOptional.orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getUserFriends(Long id) {
        return usersRepository.findFriends(id);
    }
}
