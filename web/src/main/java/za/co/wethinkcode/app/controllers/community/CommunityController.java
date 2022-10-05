package za.co.wethinkcode.app.controllers.community;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.javalin.http.Context;
import za.co.wethinkcode.app.data.Data;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Post;

public class CommunityController {
    private static final String PATH = "/community";

    public static void renderCommunityPage(Context context) throws JsonMappingException, JsonProcessingException{

        AuthenticUser sessionkey = context.sessionAttribute("user");

        List<Post> posts = Data.INSTANCE.posts();
        System.out.println(posts);
        Map<String, Object> viewModel =
                Map.of("comments", posts);
        context.render("/community.html", viewModel);
    }

    public static void handlePost(Context context) throws IOException, InterruptedException{
        AuthenticUser sessionkey = context.sessionAttribute("user");
        Post post = new Post();

        post.setPost(context.formParam("post"));

        String res = Data.INSTANCE.newPost(post);
        System.out.println(res.toString());

        Map<String, Object> viewModel =
                Map.of("response", res);
        context.render("/jobs.html", viewModel);
    }

    public static String getPath() {
        return PATH;
    }    
}
