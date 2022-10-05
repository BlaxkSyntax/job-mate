package za.co.wethinkcode.database.orm;

import java.util.Optional;

/**
 * 
 */

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import za.co.wethinkcode.database.model.Register;

public interface Query extends BaseQuery {

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE email = ?1")
    Register findbyEmail(String email);
}
