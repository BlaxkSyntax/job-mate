package za.co.wethinkcode.database.orm;

import java.util.List;

/**
 * 
 */

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Comment;

public interface Query extends BaseQuery {
   
    /**
     * 
     */
    @Update("INSERT INTO Comments (id, postid, comment) " + "VALUES (?{1}, ?{2}, ?{3})")
    void addComment(String id, String postid, String comment);

    /**
     * 
     */
    @Select("SELECT * FROM comments")
    List<Comment> findComment();

    /**
     * 
     */
    @Select("SELECT * FROM comments WHERE id = ?1")
    List<Comment> findbyPostId(String id);

    /**
     * 
     */
    @Select("SELECT * FROM comments WHERE id = ?1")
    Comment findbyEmail(String id);
   
}
