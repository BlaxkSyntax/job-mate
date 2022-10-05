package za.co.wethinkcode.post;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Memory;
import za.co.wethinkcode.database.job.Repo;
import za.co.wethinkcode.database.model.Post;

public class HandlePosts {
    private final static String PATH = "/post";

    public static void doPost(Context context) throws JsonMappingException, JsonProcessingException, SQLException{
        Post post = new ObjectMapper().readValue(context.body(), Post.class);

        String r = Memory.INSTANCE.addPost(post);
        context.result(r);
    }

    public static void getPosts(Context context) throws SQLException, JsonMappingException, JsonProcessingException{

        List<Post> r = Repo.INSTANCE.posts();
        context.result(r.toString());

    }

    public static String getPath(){
        return PATH;
    }
}