package za.co.wethinkcode.app.data.httpRequest;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import za.co.wethinkcode.app.data.Data;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Jobs;
import za.co.wethinkcode.app.model.Post;
import za.co.wethinkcode.app.model.Register;
import za.co.wethinkcode.app.model.Signin;

public class DataRequest implements Data{

    private static final int SIGNIN_PORT = 5001;
    private static final String LOGIN_URL = "http://localhost:" + SIGNIN_PORT;

    private static final int JOB_PORT = 5003;
    private static final String JOB_URL = "http://localhost:" + JOB_PORT;

    private static final int REGISTER_PORT = 5002;
    private static final String REGISTER_URL = "http://localhost:" + REGISTER_PORT;

    private static final int POST_PORT = 5004;
    private static final String POST_URL = "http://localhost:" + POST_PORT;


    /**
     * {@inheritDoc}
     */
    @Override
    public AuthenticUser newSignin(Signin person) throws JsonMappingException, JsonProcessingException {

        HttpResponse<String> resp = Unirest.post(LOGIN_URL + "/signin").
        header("accept", "application/json").
        header("Content-Type", "application/json").
        body(person.toString()).asString();
        
        AuthenticUser user = new ObjectMapper().readValue(resp.getBody(), AuthenticUser.class);
        System.out.println(user.toString());
        return user;
    }


    @Override
    public AuthenticUser newRegister(Register register) throws JsonMappingException, JsonProcessingException {
        HttpResponse<String> resp = Unirest.post(REGISTER_URL + "/register").
        header("accept", "application/json").
        header("Content-Type", "application/json").
        body(register.toString()).asString();
        
        AuthenticUser user = new ObjectMapper().readValue(resp.getBody(), AuthenticUser.class);
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String newJob(Jobs job) throws JsonMappingException, JsonProcessingException {
        HttpResponse<String> resp = Unirest.post(JOB_URL + "/job").
        header("accept", "application/json").
        header("Content-Type", "application/json").
        body(job.toString()).asString();

        String newJobResponse = resp.getBody();
        return newJobResponse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Jobs> jobs() throws JsonMappingException, JsonProcessingException {
        HttpResponse<String> resp = Unirest.get(JOB_URL + "/jobs").
        header("accept", "application/json").
        header("Content-Type", "application/json").asString();

        List<Jobs> newJobResponse = new ObjectMapper().readValue(resp.getBody(), new TypeReference<List<Jobs>>(){});
        return newJobResponse;
    }


    @Override
    public String newPost(Post post) throws JsonMappingException, JsonProcessingException {
        HttpResponse<String> resp = Unirest.post(POST_URL + "/post").
        header("accept", "application/json").
        header("Content-Type", "application/json").
        body(post.toString()).asString();

        String newJobResponse = resp.getBody();
        return newJobResponse;
    }


    @Override
    public List<Post> posts() throws JsonMappingException, JsonProcessingException {
        HttpResponse<String> resp = Unirest.get(POST_URL + "/post").
        header("accept", "application/json").
        header("Content-Type", "application/json").asString();

        List<Post> newJobResponse = new ObjectMapper().readValue(resp.getBody(), new TypeReference<List<Post>>(){});
        return newJobResponse;
    }
    
}
