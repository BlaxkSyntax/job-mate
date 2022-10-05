package za.co.wethinkcode.database.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

//import kong.unirest.HttpResponse;
//import kong.unirest.JsonNode;
//import kong.unirest.Unirest;
//import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.Experience;
import za.co.wethinkcode.database.service.Connector;

/**
 * 
 */
public class Repo implements Memory{

    private Connection connection;
    private String url = "jdbc:sqlite:test.db";
    private Connector con = new Connector(connection,url);
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
    public Experience addUser(Experience user) throws SQLException, JsonMappingException, JsonProcessingException {
        
        System.out.println(user.toString());
        //con.setConnection();
        //Query query = QueryTool.getQuery(con.getConnection(), Query.class);
        //HttpResponse<JsonNode> jsonResponse = Unirest.post(BASE_URL + "/authentication").
				//header("accept", "application/json").
				//header("Content-Type", "application/json").body(user.toString()).
				//asJson();
        //User u = new ObjectMapper().readValue(jsonResponse.getBody().toString(), User.class);
        return new Experience("email@email","123");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLogin(Experience user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLogin(Experience user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Experience> findLoginUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Experience> findLoginUser(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Experience> findLoginUser(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Experience> findLoginUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableList<Experience> findUsers() {
        // TODO Auto-generated method stub
        return null;
    }
}
