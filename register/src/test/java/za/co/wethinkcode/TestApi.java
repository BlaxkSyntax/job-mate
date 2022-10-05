package za.co.wethinkcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import za.co.wethinkcode.register.HandleRegistrations;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestApi {
    static final ObjectMapper mapper = new ObjectMapper();
    private static final int TEST_SERVER_PORT = 5002;
    private static final String BASE_URL = "http://localhost:" + TEST_SERVER_PORT;
    static RegisterServer registerServer;

    @BeforeAll
    public static void startServer() {
        registerServer = new RegisterServer();
        registerServer.start(TEST_SERVER_PORT);
    }

    @AfterAll
    public static void stopServer() {
        registerServer.close();
    }

    @Test
    @DisplayName("Server status: GET /register")
    void testRegister() {
        HttpResponse<String> resp = Unirest.get(BASE_URL + "/register").asString();
        assertThat(resp.getStatus()).isEqualTo(200);
    }

    @Test
    @DisplayName("API route: /register")
    void testUpdatePath(){
        assertThat(HandleRegistrations.getPath()).isEqualTo("/register");
    }
    

}
