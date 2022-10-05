package za.co.wethinkcode.database.job;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import za.co.wethinkcode.database.model.Register;
//import net.lemnik.eodsql.QueryTool;

/**
 * 
 */
public class Repo implements Memory{

    private static final int TEST_SERVER_PORT = 3290;
    private static final String BASE_URL = "http://localhost:" + TEST_SERVER_PORT;

    public void testData(){}

    /**
     * {@inheritDoc}
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @throws SQLException
     */
    @Override
    public Register findUser(String email) throws JsonMappingException, JsonProcessingException{

        System.out.println("request to register server"+email);

        HttpResponse<JsonNode> response = Unirest.get(BASE_URL + "/register").
        queryString("email", email).
		header("accept", "application/json").asJson();
        System.out.println("register resposnse:" +response.getBody().toString());
        
        return new ObjectMapper().readValue(response.getBody().toString(), Register.class);
    }
}
