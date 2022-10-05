package za.co.wethinkcode.database.orm;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Register;

public interface Query extends BaseQuery {

    @Update("INSERT INTO registered (id, name, surname, email, password, date) " + "VALUES (?{1}, ?{2}, ?{3}, ?{4}, ?{5}, ?{6})")
    void addNewUser(String Id, String name, String surname, String email, String password, String date);
    
    /**
     * 
     */
    @Select("SELECT * FROM registered WHERE id = ?1")
    Register findbyUserId(String userId);

     /**
     * 
     */
    @Select("SELECT * FROM registered WHERE email = ?1")
    Register findbyUserEmail(String Email);
}