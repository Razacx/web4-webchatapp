package web.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.model.Person;
import service.ChatService;
import web.Action;
import web.ActionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Action(value = "getFriends", requiresLoggedIn = true)
public class GetFriendsHandler extends ActionHandler {

    public GetFriendsHandler(ChatService chatService) {
        super(chatService);
    }

    @Override
    public void handleImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Person person = (Person) request.getSession().getAttribute("person");

        List<Person> friends = person.getFriends();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(friends);

        response.getWriter().write(json);
        response.getWriter().flush();

    }

}
