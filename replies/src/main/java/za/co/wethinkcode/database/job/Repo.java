package za.co.wethinkcode.database.job;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.collect.ImmutableList;

import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.Reply;
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
    public String addNewReply(Reply reply) throws SQLException, JsonMappingException, JsonProcessingException {
        
        System.out.println(reply.toString());
        
        query.addReply(reply.getId(), reply.getCommentid() ,reply.getReply());
        return "added reply";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Reply> findReply() {
        List<Reply> j = query.findReply();
        System.out.println(j.get(0));
        return j;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLogin(Reply user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLogin(Reply user) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Reply> findLoginUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Reply> findLoginUser(LocalDate date) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Reply> findLoginUser(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Reply> findLoginUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableList<Reply> findUsers() {
        // TODO Auto-generated method stub
        return null;
    }
}
