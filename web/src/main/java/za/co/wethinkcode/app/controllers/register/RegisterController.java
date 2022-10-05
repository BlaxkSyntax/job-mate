package za.co.wethinkcode.app.controllers.register;

import java.io.IOException;
import java.util.Map;

import io.javalin.http.Context;
import za.co.wethinkcode.app.data.Data;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Register;
import za.co.wethinkcode.app.model.Signin;

public class RegisterController {
    
    private static final String USER_PATH = "/register";
    private static final String PATH = "/register";
    public static final String ROOT_PATH = "/index.html";

    public static void renderRegisterPage(Context context) throws IOException, InterruptedException{
        //Register register = new Register();
        //signins.setEmail(context.formParam("email"));
        //signins.setPassword(context.formParam("password"));
        //signins.setCookie(context.cookie("JSESSIONID"));
        //Register user = Data.INSTANCE.newRegister(register);
        //context.sessionAttribute("user", user);

        //if (user.getUserid() == null || user.getAuthkey() == null) {
            //context.redirect(ROOT_PATH);
            //return;
        //}

        Map<String, Object> viewModel =
                Map.of();
        context.render("/register.html", viewModel);
    }

    public static String getUserPath() {
        return USER_PATH;
    }

    public static void handleRegister(Context context) throws IOException, InterruptedException{
        Register register = new Register();
        register.setName(context.formParam("name"));
        register.setSurname(context.formParam("surname"));
        register.setEmail(context.formParam("email"));
        register.setPassword(context.formParam("password"));
        System.out.println(register.toString());

        AuthenticUser users = Data.INSTANCE.newRegister(register);
        Signin signin = new Signin();
        signin.setEmail(context.formParam("email"));
        signin.setPassword(context.formParam("password"));

        AuthenticUser user = Data.INSTANCE.newSignin(signin);
        context.sessionAttribute("user", user);

        if (user.getId() == null) {
            context.redirect(ROOT_PATH);
            return;
        }

        Map<String, Object> viewModel =
                Map.of();
        context.render("/home.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    } 
}
