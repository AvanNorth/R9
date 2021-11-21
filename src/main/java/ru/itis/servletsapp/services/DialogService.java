package ru.itis.servletsapp.services;

import ru.itis.servletsapp.dto.MsgDto;
import ru.itis.servletsapp.model.Dialog;
import ru.itis.servletsapp.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface DialogService {
    List<User> getUsers(Long dialogId);
    List<Dialog> getDialogs();

    Dialog getDialogById(Long dialogId);
    void updateTime(Long dialogId, Timestamp time);
}
