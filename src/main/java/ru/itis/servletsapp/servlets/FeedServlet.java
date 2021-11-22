package ru.itis.servletsapp.servlets;

import ru.itis.servletsapp.dto.PostDto;
import ru.itis.servletsapp.dto.UserDto;
import ru.itis.servletsapp.model.Post;
import ru.itis.servletsapp.model.User;
import ru.itis.servletsapp.services.PostsService;
import ru.itis.servletsapp.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/feed")
public class FeedServlet extends HttpServlet {
    private PostsService postsService;
    private UserService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        postsService = (PostsService) config.getServletContext().getAttribute("postsService");
        usersService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = (UserDto) req.getSession(true).getAttribute("user");

        List<PostDto> posts = new LinkedList<>();

        List<User> friends = usersService.getUserFriends(userDto.getId());

        for (User user: friends){
            List<PostDto> friendPosts = postsService.getByAuthorId(user.getId());

            posts.addAll(friendPosts);
        }

        req.setAttribute("posts", posts);
        req.getRequestDispatcher("feed.ftl").forward(req,resp);
    }
}
