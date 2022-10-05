package za.co.wethinkcode.database.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.AuthenticUser;
import za.co.wethinkcode.database.model.Login;
import za.co.wethinkcode.database.service.Connector;

/**
 * 
 */
public class Repo implements Memory{

    //private Connection connection;
    //private String url = "jdbc:sqlite:test.db";
    //private Connector con = new Connector(connection,url);
    private static final int TEST_SERVER_PORT = 3290;
    private static final String BASE_URL = "http://localhost:" + TEST_SERVER_PORT;
    

    public void testData(){}

    /**
     * {@inheritDoc}
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @Override
    public AuthenticUser addUser(Login login) throws SQLException, JsonMappingException, JsonProcessingException {

        System.out.println("requestion to authserver"+login.toString());
        HttpResponse<String> jsonResponse = Unirest.get(BASE_URL + "/authentication").
				header("accept", "application/json").
				header("Content-Type", "application/json").queryString("email", login.getEmail()).asString();
                AuthenticUser user = new ObjectMapper().readValue(jsonResponse.getBody(), AuthenticUser.class);
                
                System.out.println(jsonResponse.getBody());
        return user;
    }
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(Login user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateLogin(Login user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Login> findLoginUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Login> findLoginUser(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Login> findLoginUser(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableList<Login> findUsers() {
        // TODO Auto-generated method stub
        return null;
    }

}
