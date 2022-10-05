package za.co.wethinkcode.app.controllers.contact;

import java.util.Map;

import io.javalin.http.Context;

public class ContactController {
    private static final String PATH = "/contact";

    public static void renderContactPage(Context context){
        String sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("contact.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
