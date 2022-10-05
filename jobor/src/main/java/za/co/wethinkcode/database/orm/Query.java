package za.co.wethinkcode.database.orm;

import java.util.List;

/**
 * 
 */


import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Jobs;

public interface Query extends BaseQuery {
    
     @Update("INSERT INTO jobs (id, position, area, jobtype, jobDescription , responsibilities, qualifications, benefits, startDate, endDate, applicationtype, contact) " + "VALUES (?{1}, ?{2}, ?{3}, ?{4}, ?{5}, ?{6},?{7}, ?{8}, ?{9}, ?{10}, ?{11}, ?{12})")
    void addNewJob(String Id, String position, String area, String jobtype, String jobDescription, String responsibilities, String qualifications, String benefits, String startDate, String endData, String applicationtype, String contact);
    

    /**
     * 
     */
    @Select("SELECT * FROM jobs")
    List<Jobs> findAllJob();

    /**
     * 
     */
    @Select("SELECT * FROM jobs WHERE id = ?1")
    Jobs findbyJobId(String userId);

     /**
     * 
     */
    @Select("SELECT * FROM jobs WHERE jobtype = ?1")
    Jobs findbyJobType(String jobtype);
   
}
