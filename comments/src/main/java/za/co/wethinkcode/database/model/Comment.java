package za.co.wethinkcode.database.model;

import net.lemnik.eodsql.ResultColumn;

/**
*/
public class Comment {

    private String id;
    private String postid;
    private String comment;

    public String getComment() {
        return comment;
    }

    @ResultColumn( value = "comment" )
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    @ResultColumn( value = "id" )
    public void setId(String id) {
        this.id = id;
    }

    public String getPostid() {
        return postid;
    }

    @ResultColumn( value = "postid" )
    public void setPostid(String postid) {
        this.postid = postid;
    }

    @Override
    public String toString(){
        return "{"+
                    "\"postid\" :" +"\""+ getPostid()+ "\""+","+"\"id\" :" +"\""+getId()+"\""+","+"\"comment\" :" +"\""+getComment()+"\""
                +"}";
    }
    
}
