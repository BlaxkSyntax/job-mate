package za.co.wethinkcode.app.controllers.resume;

import java.util.Map;

import io.javalin.http.Context;
import za.co.wethinkcode.app.model.AuthenticUser;

public class ResumeController {
    private static final String PATH = "/resume";

    public static void renderResumePage(Context context){
        AuthenticUser user = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("/resume.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
