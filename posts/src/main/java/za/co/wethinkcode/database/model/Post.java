package za.co.wethinkcode.database.model;

import net.lemnik.eodsql.ResultColumn;

/**
*/
public class Post {
    
    private String id;
    private String post;
    
    public String getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    @ResultColumn( value = "post" )
    public void setPost(String post) {
        this.post = post;
    }

    @ResultColumn( value = "id" )
    public void setId(String id) {
        this.id = id;
    } 

    public String toString(){
        return "{"
                    +"\"id\":"+"\""+getId()+"\","
                    +"\"post\":"+"\""+getPost()+"\"" +
                "}";
    }
}
