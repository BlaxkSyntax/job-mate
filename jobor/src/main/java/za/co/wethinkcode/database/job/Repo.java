package za.co.wethinkcode.database.job;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import net.lemnik.eodsql.QueryTool;
//import net.lemnik.eodsql.QueryTool;
import za.co.wethinkcode.database.model.Jobs;
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
    public String addNewJob(Jobs job) throws SQLException, JsonMappingException, JsonProcessingException {
        System.out.println(job.toString());
        
        query.addNewJob(job.getId(), job.getPosition(), job.getArea(), job.getJobtype(), job.getJobDescription(), job.getResponsibilities(), job.getQualifications(), job.getBenefits(), job.getStartDate(), job.getEndDate(), job.getApplicationtype(), job.getContact());
        
        return "job add";
    }

    /**
     * {@inheritDoc}
     * @throws SQLException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    @Override
    public List<Jobs> jobs() throws SQLException, JsonMappingException, JsonProcessingException {
        //con.setConnection();
        //Query query = QueryTool.getQuery(con.getConnection(), Query.class);
        List<Jobs> j = query.findAllJob();
        System.out.println(j.get(0));
        return j;
    }
}
