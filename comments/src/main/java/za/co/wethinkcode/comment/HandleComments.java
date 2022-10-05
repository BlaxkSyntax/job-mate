package za.co.wethinkcode.comment;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.job.Repo;
import za.co.wethinkcode.database.model.Comment;

public class HandleComments {
    private final static String PATH = "/comment";

    public static void doComment(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        
        Comment comment = new ObjectMapper().readValue(context.body(), Comment.class);

        String reg = Memory.INSTANCE.addNewComment(comment);
        context.result(reg);
    }

    public static void getComments(Context context) throws SQLException, JsonMappingException, JsonProcessingException{

        List<Comment> r = Repo.INSTANCE.findComment();
        context.result(r.toString());

    }

    public static String getPath(){
        return PATH;
    }
}