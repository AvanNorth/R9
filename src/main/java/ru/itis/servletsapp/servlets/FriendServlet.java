package ru.itis.servletsapp.servlets;

import ru.itis.servletsapp.dto.UserDto;
import ru.itis.servletsapp.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/friends")
public class FriendServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getSession(true).getAttribute("user");

        req.setAttribute("friends", userService.getUserFriends(userDto.getId()));
        req.getRequestDispatcher("friends.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getSession(true).getAttribute("user");

       String newFriendId = req.getParameter("addId");
       String delFriendId = req.getParameter("delId");
       if (newFriendId != null){
           userService.addUserFriend(userDto.getId(), Long.parseLong(newFriendId));
       }else if(delFriendId != null){
           userService.deleteUserFriend(userDto.getId(), Long.parseLong(delFriendId));
       }else resp.sendError(400);
    }
}
