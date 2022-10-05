package za.co.wethinkcode.app.controllers.pricing;

import java.util.Map;

import io.javalin.http.Context;

public class PricingController {
    private static final String PATH = "/pricing";

    public static void renderPricingPage(Context context){
        String sessionkey = context.sessionAttribute("user");

        Map<String, Object> viewModel =
                Map.of();

        context.render("/pricing.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
