package ru.itis.servletsapp.servlets;

import ru.itis.servletsapp.dto.UserDto;
import ru.itis.servletsapp.model.Dialog;
import ru.itis.servletsapp.model.User;
import ru.itis.servletsapp.services.DialogService;
import ru.itis.servletsapp.services.MsgsService;
import ru.itis.servletsapp.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/im")
public class MsgServlet extends HttpServlet {
    private UserService userService;
    private MsgsService msgsService;
    private DialogService dialogService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
        msgsService = (MsgsService) config.getServletContext().getAttribute("msgsService");
        dialogService = (DialogService) config.getServletContext().getAttribute("dialogService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dialogId = req.getParameter("sel");
        UserDto userDto = (UserDto) req.getSession(true).getAttribute("user");

        if(dialogId != null){
            Long dialogIdL = Long.parseLong(dialogId);
            Dialog dialog = dialogService.getDialogById(dialogIdL);
            List<User> users = dialogService.getUsers(dialogIdL);
            if (users.get(0).getId().equals(userDto.getId()) || users.get(1).getId().equals(userDto.getId()) ){
                req.setAttribute("dialog",dialog);
                req.setAttribute("user", userDto);

                System.out.println(users.size());
                System.out.println("-------------------");
                System.out.println(users.indexOf(User.from(userDto)));
                req.setAttribute("interloc", users.get(users.size() - users.indexOf(User.from(userDto)) - 1));
                req.setAttribute("messages",msgsService.getByDialogId(dialogIdL));
                req.getRequestDispatcher("messages.ftl").forward(req,resp);
            }
        }else {
            req.setAttribute("dialogs",dialogService.getDialogs());
            req.getRequestDispatcher("dialogs.ftl").forward(req,resp);
        }
    }
}
