package za.co.wethinkcode;

import org.jetbrains.annotations.NotNull;

import io.javalin.Javalin;
import za.co.wethinkcode.authentication.HandleAuthentication;

//import java.time.LocalDate;
//import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AuthServer {
    private static final int DEFAULT_PORT = 3290;
    private final Javalin app;


    /**
     * The main class starts the server on the default port 7070.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        AuthServer server = new AuthServer();
        server.start(DEFAULT_PORT);
    }

    public AuthServer() {
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
            SigninAndSignoutRoutes();
        });
    }

    private void SigninAndSignoutRoutes() {
        get(HandleAuthentication.getPath(), HandleAuthentication::doAuth);
    }

    @NotNull
    private Javalin createAndConfigureServer() {
        return Javalin.create(config -> {
            config.enableDevLogging();
        });
    }
}