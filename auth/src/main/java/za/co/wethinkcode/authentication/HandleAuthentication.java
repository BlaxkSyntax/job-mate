package za.co.wethinkcode.authentication;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.model.AuthenticUser;
import za.co.wethinkcode.database.model.Register;


public class HandleAuthentication {
    private final static String PATH = "/authentication";
    AuthenticUser authuser = new AuthenticUser();

    public static void doAuth(Context context) throws SQLException, JsonMappingException, JsonProcessingException{

        AuthenticUser authuser = new AuthenticUser();
        System.out.println(context.queryParam("email"));
        Register registerUser = Memory.INSTANCE.findUser(context.queryParam("email"));
        authuser.setId(registerUser.getId());
        authuser.setUsername(registerUser.getEmail());
        if(registerUser.toString().equals(null)){
            context.result("User Doesnt Exist");
        }else{
            context.result(authuser.toString());
        }
    }

    public static String getPath(){
        return PATH;
    }
}