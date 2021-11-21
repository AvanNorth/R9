package ru.itis.servletsapp.services.impl;

import ru.itis.servletsapp.dao.DialogRepository;
import ru.itis.servletsapp.exceptions.NotFoundException;
import ru.itis.servletsapp.model.Dialog;
import ru.itis.servletsapp.model.User;
import ru.itis.servletsapp.services.DialogService;

import java.sql.Timestamp;
import java.util.*;


public class DialogServiceImpl implements DialogService {

    private final DialogRepository dialogRepository;

    public DialogServiceImpl(DialogRepository dialogRepository) {
        this.dialogRepository = dialogRepository;
    }


    @Override
    public List<User> getUsers(Long dialogId) {
        return dialogRepository.findUsers(dialogId);
    }

    @Override
    public List<Dialog> getDialogs() {
        return dialogRepository.findAll();
    }

    @Override
    public Dialog getDialogById(Long dialogId) {
       Optional<Dialog> dOptional= dialogRepository.findById(dialogId);
        return dOptional.orElseThrow(() -> new NotFoundException("Dialog not found"));
    }

    @Override
    public void updateTime(Long dialogId, Timestamp time) {
        Dialog dialog = Dialog.builder().id(dialogId).lastMsg(time).build();
        dialogRepository.save(dialog);
    }
}
