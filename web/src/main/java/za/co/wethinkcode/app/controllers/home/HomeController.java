package za.co.wethinkcode.app.controllers.home;

import io.javalin.http.Context;
import za.co.wethinkcode.app.model.AuthenticUser;

import java.util.Map;

public class HomeController {
    private static final String PATH = "/home";

    public static void renderHomePage(Context context){
        AuthenticUser sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("/home.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    }
}