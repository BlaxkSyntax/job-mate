package za.co.wethinkcode.register;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.model.Register;

public class HandleRegistrations {
    private final static String PATH = "/register";

    public static void doRegister(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        //System.out.println(context.body());
        Register user = new ObjectMapper().readValue(context.body(), Register.class);
        Register r = Memory.INSTANCE.findRegisteredByEmail(user.getEmail());
        if(r.toString() == null){
            Memory.INSTANCE.newRegister(user);
            context.result("USER ADDED");
        }else{
            context.result("USER EXISTS");
        }
    }

    public static void getRegistered(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        //System.out.println(context.body());
        Register r = Memory.INSTANCE.findRegisteredByEmail(context.queryParam("email"));
        if(r.toString() != null){
            context.result(r.toString());
        }else{
            context.result("bad request");
        }
    }

    public static String getPath(){
        return PATH;
    }
}