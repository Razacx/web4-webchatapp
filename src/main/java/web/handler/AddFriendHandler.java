package web.handler;

import domain.model.Person;
import service.ChatService;
import web.Action;
import web.ActionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Action(value = "addFriend", requiresLoggedIn = true)
public class AddFriendHandler extends ActionHandler {

    public AddFriendHandler(ChatService chatService) {
        super(chatService);
    }

    @Override
    public void handleImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Person person = (Person) request.getSession().getAttribute("person");
        if (person == null) {
            redirect(response, "Controller?action=requestLogin");
        }

        String friendUsername = request.getParameter("username");
        Person friend = getChatService().getPerson(friendUsername);

        try {
            person.addFriend(friend);
        } catch (NullPointerException e) {
            response.getWriter().write("User does not exist");
        } catch (IllegalArgumentException e) {
            response.getWriter().write("User is already a friend");
        }
        response.getWriter().flush();

    }

}
