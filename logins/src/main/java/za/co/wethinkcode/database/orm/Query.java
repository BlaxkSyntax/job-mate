package za.co.wethinkcode.database.orm;

/**
 * 
 */

import com.google.common.collect.ImmutableList;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Login;

public interface Query extends BaseQuery {

    @Update("INSERT INTO registered (id, name, surname, email, password, date) " + "VALUES (?{1}, ?{2}, ?{3}, ?{4}, ?{5}, ?{6})")
    void addNewUser(String Id, String name, String surname, String email, String password, String date);
    
    /**
     * 
     */
    @Select("SELECT * FROM login WHERE loginID = ?1")
    Login findbyLoginId(String LoginID);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE id = ?1")
    Login findbyId(long id);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE email = ?1")
    Login findbyEmail(String email);

    /**
     * 
     */
    @Select("SELECT * FROM login ORDER BY timedate")
    ImmutableList<Login> findAll();

    /**
     * 
     */
    @Select("SELECT * FROM login ORDER BY timedate")
    Login[] findALL();

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
