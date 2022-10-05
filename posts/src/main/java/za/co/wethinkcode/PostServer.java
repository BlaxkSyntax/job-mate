package za.co.wethinkcode;

import org.jetbrains.annotations.NotNull;

import io.javalin.Javalin;
import za.co.wethinkcode.post.HandlePosts;

//import java.time.LocalDate;
//import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class PostServer {
    private static final int DEFAULT_PORT = 5004;
    private final Javalin app;


    /**
     * The main class starts the server on the default port 7070.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PostServer server = new PostServer();
        server.start(DEFAULT_PORT);
    }

    public PostServer() {
        app = createAndConfigureServer();
        setupRoutes(app);
    }

    public void start(int port) {
       app.start(port);
    }

    public int port() {
        return app.port();
    }

    public void close() {
        app.close();
    }

    private void setupRoutes(Javalin server) {
        server.routes(() -> {
            postRoutes();
        });
    }

    private void postRoutes() {
        post(HandlePosts.getPath(), HandlePosts::doPost);
        get(HandlePosts.getPath(), HandlePosts::getPosts);
    }

    @NotNull
    private Javalin createAndConfigureServer() {
        return Javalin.create(config -> {
            config.enableDevLogging();
        });
    }
}