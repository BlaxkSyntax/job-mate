package za.co.wethinkcode.app;

import io.javalin.core.security.AccessManager;
import io.javalin.core.security.RouteRole;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import za.co.wethinkcode.app.controllers.signing.SigningController;
import za.co.wethinkcode.app.model.AuthenticUser;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DefaultAccessManager implements AccessManager {
    @Override
    public void manage(@NotNull Handler handler, @NotNull Context context, @NotNull Set<RouteRole> set) throws Exception {
        // Get the user (which is a Person object) from the session handler
        //AuthenticUser user = context.sessionAttribute("user");

        // If there is no user in the session handler and this is not the login URL
        // then redirect the user to the login page (/index.html)
        // or just let the current handler continue processing the request.

        //if(user == null && context.path().equals("/user-register")) {
            //context.render("/register.html");
        //} else if (user == null && !context.path().equals("/signin")) {
            //redirectToLogin(context);
        //} else if(user == null && context.path().equals("/register")) {
            //context.render("/register.html");
        //} else {
            //handler.handle(context);
        //}
    }

    private static void redirectToLogin(Context ctx) {
        //ctx.redirect(SigningController.ROOT_PATH);
    }
}