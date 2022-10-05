package za.co.wethinkcode.cv;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.job.CvMapper;
import za.co.wethinkcode.database.model.Cv;

public class HandleCv {
    private final static String PATH = "/register";

    public static void doRegister(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        CvMapper user = new ObjectMapper().readValue(context.body(), CvMapper.class);
        Cv reg = Memory.INSTANCE.addUser(new Cv(user.getEmail(),user.getPassword()));
        context.result(reg.toString());
    }

    public static String getPath(){
        return PATH;
    }
}