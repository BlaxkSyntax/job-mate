package za.co.wethinkcode.reply;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.job.Repo;
import za.co.wethinkcode.database.model.Reply;

public class HandleReplies {
    private final static String PATH = "/reply";

    public static void doReply(Context context) throws JsonMappingException, JsonProcessingException, SQLException{
        Reply post = new ObjectMapper().readValue(context.body(), Reply.class);

        String r = Memory.INSTANCE.addNewReply(post);
        context.result(r);
    }

    public static void getReply(Context context) throws SQLException, JsonMappingException, JsonProcessingException{

        List<Reply> r = Repo.INSTANCE.findReply();
        context.result(r.toString());

    }

    public static String getPath(){
        return PATH;
    }
}