package za.co.wethinkcode.app.data;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import za.co.wethinkcode.app.data.httpRequest.DataRequest;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Jobs;
import za.co.wethinkcode.app.model.Post;
import za.co.wethinkcode.app.model.Register;
import za.co.wethinkcode.app.model.Signin;

public interface Data {
    
    Data INSTANCE = new DataRequest();

    static Data getInstance(){
        return INSTANCE;
    }

    //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    AuthenticUser newRegister(Register person) throws JsonMappingException, JsonProcessingException;

    //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    AuthenticUser newSignin(Signin person) throws JsonMappingException, JsonProcessingException;

    //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    String newJob(Jobs job) throws JsonMappingException, JsonProcessingException;

    //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    List<Jobs> jobs() throws JsonMappingException, JsonProcessingException;

    //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    String newPost(Post post) throws JsonMappingException, JsonProcessingException;

     //<editor-fold desc="Persons">
    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param person A non-null Person instance.
     * @return The Person instance you added or that already existed in the db.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    List<Post> posts() throws JsonMappingException, JsonProcessingException;
}
