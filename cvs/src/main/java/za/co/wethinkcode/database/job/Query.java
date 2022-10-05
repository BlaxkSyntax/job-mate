package za.co.wethinkcode.database.job;

/**
 * 
 */

import com.google.common.collect.ImmutableList;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Cv;

public interface Query extends BaseQuery {
    
    /**
     * 
     */
    @Select("SELECT * FROM login WHERE loginID = ?1")
    Cv findbyLoginId(String LoginID);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE id = ?1")
    Cv findbyId(long id);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE email = ?1")
    Cv findbyEmail(String email);

    /**
     * 
     */
    @Select("SELECT * FROM login ORDER BY timedate")
    ImmutableList<Cv> findAll();

    /**
     * 
     */
    @Select("SELECT * FROM login ORDER BY timedate")
    Cv[] findALL();

    /**
     * 
     */
    @Update("INSERT INTO login (id, email, logindate, loginid) " + "VALUES (?{1}, ?{2}, ?{3}, ?{4})")
    void addLogin(long id, String email, String logindate, String loginid);

    /**
     * 
     */
    @Update("INSERT INTO login (id, email, logindate, loginid) " + "VALUES (?{1}, ?{2}, ?{3}, ?{4})")
    void 
    
    uLogin(long id, String email, String logindate, String loginid);    
}
