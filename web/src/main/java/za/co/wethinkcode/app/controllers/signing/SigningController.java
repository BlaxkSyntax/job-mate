package za.co.wethinkcode.app.controllers.signing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.javalin.http.Context;
import za.co.wethinkcode.app.controllers.home.HomeController;
import za.co.wethinkcode.app.data.Data;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Signin;

public class SigningController {
    private static final String SIGNIN_PATH = "/signin";
    public static final String SIGNOUT_PATH = "/signout";
    public static final String ROOT_PATH = "/index.html";

    public static void handlesignin(Context context) throws JsonMappingException, JsonProcessingException {

        Signin signins = new Signin();
        signins.setEmail(context.formParam("email"));
        signins.setPassword(context.formParam("password"));
        
        AuthenticUser user = Data.INSTANCE.newSignin(signins);
        context.sessionAttribute("user", user);

        if (user.getId() == null) {
            context.redirect(ROOT_PATH);
            return;
        }
        context.redirect(HomeController.getPath());
    }

    public static String getSigninPath() {
        return SIGNIN_PATH;
    }

    public static void handleSignout(Context context) {
        context.sessionAttribute("user", null);
        context.redirect(ROOT_PATH);
    }
}