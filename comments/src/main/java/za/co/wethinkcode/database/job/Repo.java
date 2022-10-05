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
import za.co.wethinkcode.database.model.Comment;
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
    public String addNewComment(Comment comment) throws SQLException, JsonMappingException, JsonProcessingException {
        
        System.out.println(comment.toString());
        
        query.addComment(comment.getId(),comment.getPostid(),comment.getComment());
        return "added post";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Comment> findComment() {
        List<Comment> j = query.findComment();
        System.out.println(j.get(0));
        return j;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLogin(Comment user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLogin(Comment user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comment> findLoginUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comment> findLoginUser(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comment> findLoginUser(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Comment> findLoginUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
