package web.handler;

import domain.model.Person;
import service.ChatService;
import web.Action;
import web.ActionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Action(value = "index", requiresLoggedIn = true)
public class IndexHandler extends ActionHandler {

    public IndexHandler(ChatService chatService) {
        super(chatService);
    }

    public void handleImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person) request.getSession().getAttribute("person");
        request.setAttribute("person", person);
        request.setAttribute("topics", getChatService().getTopics());
        forward(request, response, "index.jsp");
    }

}
