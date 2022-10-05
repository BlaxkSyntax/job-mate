package za.co.wethinkcode.app.controllers.preparation;

import java.util.Map;

import io.javalin.http.Context;

public class PrepController {
    private static final String PATH = "/preparation";

    public static void renderPrepPage(Context context){
        String sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("/preparation.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
