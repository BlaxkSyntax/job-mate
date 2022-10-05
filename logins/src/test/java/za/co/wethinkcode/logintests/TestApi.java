package za.co.wethinkcode.logintests;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import za.co.wethinkcode.LoginsServer;
import za.co.wethinkcode.login.HandleLogins;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestApi {
    static final ObjectMapper mapper = new ObjectMapper();
    private static final int TEST_SERVER_PORT = 5001;
    private static final String BASE_URL = "http://localhost:" + TEST_SERVER_PORT;
    static LoginsServer server;

    @BeforeAll
    public static void startServer() {
        server = new LoginsServer();
        server.start(TEST_SERVER_PORT);
    }

    @AfterAll
    public static void stopServer() {
        server.close();
    }

    @Test
    @DisplayName("Server status: GET /Signin")
    void testGetSignin() {
        HttpResponse<String> resp = Unirest.get(BASE_URL + "/signin").asString();
        assertThat(resp.getStatus()).isEqualTo(200);
    }
    
    @Test
    @DisplayName("Server status: POST /Signout")
    void testSignout(){
        HttpResponse<String> resp = Unirest.post(BASE_URL + "/signout").asString();
        assertThat(resp.getBody()).isNotEqualTo(null);
    }

    @Test
    @DisplayName("Server request: POST /Signout")
    void testWebSignoutPostRequest(){
        HttpResponse<String> resp = Unirest.post(BASE_URL + "/signout").asString();
        assertThat(resp.getBody()).isEqualTo("");
    }

    @Test
    @DisplayName("API route: /Signout")
    void testSignoutPath(){
        assertThat(HandleLogins.getSignoutPath()).isEqualTo("/signout");
    }

    @Test
    @DisplayName("API route: /signin")
    void testSigninPath(){
        assertThat(HandleLogins.getSigninPath()).isEqualTo("/signin");
    }

    @Test
    @DisplayName("API route: /signin")
    void testUpdatePath(){
        assertThat(HandleLogins.getUpdatePath()).isEqualTo("/update");
    }
    

}
