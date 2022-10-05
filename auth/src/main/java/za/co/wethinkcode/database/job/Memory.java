package za.co.wethinkcode.database.job;

/**
 * 
 */


import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import za.co.wethinkcode.database.model.Register;


public interface Memory{

    Memory INSTANCE = new Repo();

    static Memory getInstance(){
        return INSTANCE;
    }

    /**
     * Find a Person instance with the given email address.
     * @param email Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     * @throws SQLException
     */
    Register findUser(String email) throws JsonMappingException, JsonProcessingException;

}
