package za.co.wethinkcode.app.controllers.about;

import java.util.Map;

import io.javalin.http.Context;

public class AboutController {
   private static final String PATH = "/about";

   public static void renderAboutPage(Context context){
        String sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("/about.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
