package za.co.wethinkcode.database.job;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 */

import java.util.Optional;
import com.google.common.collect.ImmutableList;
import za.co.wethinkcode.database.model.Register;


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
    void newRegister(Register register);

    /**
     * Remove a Person from the database. If you request removal of a Person that is not actually
     * in the database, your request will silently be ignored.
     * @param User A non-null Person instance which will be removed from the db.
     */
    void removeRegister(Register user);

    /**
     * Update the given Person instance.
     * @param user A non-null Person instance which will be updated.
     */
    void updateUpdate(Register user);


    /**
     * Find a Person instance with the given email address.
     * @param email Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     */
    Register findRegisteredByEmail(String email);

    /**
     * Answer with a Set of all Person instances in the db.
     * @return A set of Person instances, possible empty, but never {@literal null}.
     */
    ImmutableList<Register> findRegisters();
}
