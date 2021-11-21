package ru.itis.servletsapp.dao;

import ru.itis.servletsapp.dao.base.CrudRepository;
import ru.itis.servletsapp.model.Dialog;
import ru.itis.servletsapp.model.User;

import java.util.List;

public interface DialogRepository extends CrudRepository<Dialog, Long> {
    List<User> findUsers(Long dialogId);


}
