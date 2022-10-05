package za.co.wethinkcode.experience;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.job.ExperienceMapper;
import za.co.wethinkcode.database.model.Experience;

public class HandleExperience {
    private final static String PATH = "/register";

    public static void doRegister(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        ExperienceMapper user = new ObjectMapper().readValue(context.body(), ExperienceMapper.class);
        Experience reg = Memory.INSTANCE.addUser(new Experience(user.getEmail(),user.getPassword()));
        context.result(reg.toString());
    }

    public static String getPath(){
        return PATH;
    }
}