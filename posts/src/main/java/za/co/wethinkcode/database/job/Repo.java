package za.co.wethinkcode.database.job;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableList;

import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.Post;
import za.co.wethinkcode.database.orm.Query;
import za.co.wethinkcode.database.service.Connector;

/**
 * 
 */
public class Repo implements Memory{

    private Connector con = new Connector();
    private final Query query = QueryTool.getQuery(con.connection(), Query.class );

    public void testData(){}

    /**
     * {@inheritDoc}
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @Override
    public String addPost(Post post) throws SQLException, JsonMappingException, JsonProcessingException {
        
        System.out.println(post.toString());
        
        query.addPost(post.getId() ,post.getPost());
        return "added post";
    }

    /**
     * {@inheritDoc}
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @Override
    public List<Post> posts() throws SQLException, JsonMappingException, JsonProcessingException {
        
        List<Post> j = query.findAllPosts();
        System.out.println(j.get(0));
        return j;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLogin(Post user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLogin(Post user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Post> findLoginUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Post> findLoginUser(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Post> findLoginUser(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Post> findLoginUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableList<Post> findUsers() {
        // TODO Auto-generated method stub
        return null;
    }
}
