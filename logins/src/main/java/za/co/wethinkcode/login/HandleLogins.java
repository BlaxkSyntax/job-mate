package za.co.wethinkcode.login;

import java.sql.SQLException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.model.AuthenticUser;
import za.co.wethinkcode.database.model.Login;

public class HandleLogins {
    private final static String SIGNIN_PATH = "/signin";
    private final static String SIGNOUT_PATH = "/signout";
    private final static String UPDATE_PATH = "/update";

    public static void signin(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        Login user = new ObjectMapper().readValue(context.body(), Login.class);
        System.err.println("login user date:"+user);
        context.result(Memory.INSTANCE.addUser(user).toString());
    }

    public static void signout(Context context) throws JsonMappingException, JsonProcessingException{

        AuthenticUser authuser = context.sessionAttribute("user");
        //Memory.INSTANCE.removeUser(user);
    }

    public static void getSignin(Context context){
        context.result("hello");
    }

    public static void upDate(Context context){
        context.result("hello");
    }

    public static String getSigninPath(){
        return SIGNIN_PATH;
    }

    public static String getSignoutPath(){
        return SIGNOUT_PATH;
    }

    public static String getUpdatePath(){
        return UPDATE_PATH;
    }
}