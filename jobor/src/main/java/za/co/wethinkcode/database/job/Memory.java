package za.co.wethinkcode.database.job;

import java.sql.SQLException;

/**
 * 
 */

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import za.co.wethinkcode.database.model.Jobs;

public interface Memory{

    Memory INSTANCE = new Repo();

    static Memory getInstance(){
        return INSTANCE;
    }

    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param User A non-null Person instance.
     * @return The user instance you added or that already existed in the db.
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    String addNewJob(Jobs job) throws SQLException, JsonMappingException, JsonProcessingException;

    /**
     * Add a new Person instance to the datastore. If the Person passed to this method already exists
     * in the repository (they have the same ID), we'll return that instance and ignore the request.
     * If you ask for a {@literal null} Person, I will throw a NullPointerException.
     * @param User A non-null Person instance.
     * @return The user instance you added or that already existed in the db.
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    List<Jobs> jobs() throws SQLException, JsonMappingException, JsonProcessingException;
}
