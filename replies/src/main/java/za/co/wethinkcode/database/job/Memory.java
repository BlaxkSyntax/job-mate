package za.co.wethinkcode.database.job;

import java.sql.SQLException;

/**
 * 
 */

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableList;

import za.co.wethinkcode.database.model.Reply;


public interface Memory{

    Memory INSTANCE = new Repo();

    static Memory getInstance(){
        return INSTANCE;
    }

    //void setUrl(String url);

    //String getUrl();

    //void setConnection(Connection connection);

    //String getConnection();



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
    String addNewReply(Reply reply) throws SQLException, JsonMappingException, JsonProcessingException;

    /**
     * Answer with a Set of all Person instances in the db.
     * @return A set of Person instances, possible empty, but never {@literal null}.
     */
    List<Reply> findReply();

    /**
     * Remove a Person from the database. If you request removal of a Person that is not actually
     * in the database, your request will silently be ignored.
     * @param User A non-null Person instance which will be removed from the db.
     */
    void removeLogin(Reply user);

    /**
     * Update the given Person instance.
     * @param user A non-null Person instance which will be updated.
     */
    void updateLogin(Reply user);

    /**
     * Find a Person instance with the given email address.
     * @param email Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     */
    Optional<Reply> findLoginUser(String email);

    /**
     * Find a Person instance with the given email address.
     * @param date Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     */
    Optional<Reply> findLoginUser(LocalDate date);

    /**
     * Find a Person instance with the given email address.
     * @param id Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     */
    Optional<Reply> findLoginUser(UUID id);

    /**
     * Find a Person instance with the given email address.
     * @param id Email id of the Person we want to find.
     * @return An Optional containing the Person if they exist in the db, empty otherwise.
     */
    Optional<Reply> findLoginUser(Long id);

    /**
     * Answer with a Set of all Person instances in the db.
     * @return A set of Person instances, possible empty, but never {@literal null}.
     */
    ImmutableList<Reply> findUsers();
}
