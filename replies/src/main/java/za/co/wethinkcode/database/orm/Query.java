package za.co.wethinkcode.database.orm;

import java.util.List;

/**
 * 
 */

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Reply;

public interface Query extends BaseQuery {
    
    /**
     * 
     */
    @Update("INSERT INTO replies (id, commentid, reply) " + "VALUES (?{1}, ?{2}, ?{3})")
    void addReply(String id, String commentid, String reply);

    /**
     * 
     */
    @Select("SELECT * FROM replies")
    List<Reply> findReply();

    /**
     * 
     */
    @Select("SELECT * FROM replys WHERE id = ?1")
    List<Reply> findbyReplyId(String id);
   
}
