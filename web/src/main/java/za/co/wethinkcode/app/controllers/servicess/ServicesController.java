package za.co.wethinkcode.app.controllers.servicess;

import java.util.Map;

import io.javalin.http.Context;

public class ServicesController {
    private static final String PATH = "/services";

    public static void renderServicesPage(Context context){
        String sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("services.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
