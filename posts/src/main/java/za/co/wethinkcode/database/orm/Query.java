package za.co.wethinkcode.database.orm;

import java.util.List;

/**
 * 
 */

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;
import za.co.wethinkcode.database.model.Post;

public interface Query extends BaseQuery {
    
    /**
     * 
     */
    @Update("INSERT INTO post (id, post) " + "VALUES (?{1}, ?{2})")
    void addPost(String id, String post);
    
    /**
     * 
     */
    @Select("SELECT * FROM post")
    List<Post> findAllPosts();
    
    /**
     * 
     */
    @Select("SELECT * FROM login WHERE loginID = ?1")
    Post findbyLoginId(String LoginID);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE id = ?1")
    Post findbyId(long id);

    /**
     * 
     */
    @Select("SELECT * FROM login WHERE email = ?1")
    Post findbyEmail(String email);


    /**
     * 
     */
    @Select("SELECT * FROM login ORDER BY timedate")
    Post[] findALL();

    
}
