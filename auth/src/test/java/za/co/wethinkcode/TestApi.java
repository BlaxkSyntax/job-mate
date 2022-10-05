package za.co.wethinkcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import za.co.wethinkcode.AuthServer;
import za.co.wethinkcode.authentication.HandleAuthentication;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestApi {
    static final ObjectMapper mapper = new ObjectMapper();
    private static final int TEST_SERVER_PORT = 3290;
    private static final String BASE_URL = "http://localhost:" + TEST_SERVER_PORT;
    static AuthServer server;

    @BeforeAll
    public static void startServer() {
        server = new AuthServer();
        server.start(TEST_SERVER_PORT);
    }

    @AfterAll
    public static void stopServer() {
        server.close();
    }

    @Test
    @DisplayName("Server status: GET /authentication")
    void testAuthentication() {
        HttpResponse<String> resp = Unirest.get(BASE_URL + "/authentication?email=email@emaill").asString();
        assertThat(resp.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("API route: /authentication")
    void testUpdatePath(){
        assertThat(HandleAuthentication.getPath()).isEqualTo("/authentication");
    }
    

}
