package ru.itis.servletsapp.dao;

import ru.itis.servletsapp.dao.base.CrudRepository;
import ru.itis.servletsapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
    List<User> findFriends(Long id);
    void setFriend(Long id, Long friendId);
    void updateAvatarForUser(Long userId, Long fileId);
    Optional<String> getTokenByUserId(Long userId);
    void createTokenForUser(Long userId, String token);
    void updateTokenForUser(Long userId, String token);
}
