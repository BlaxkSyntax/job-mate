package za.co.wethinkcode.database.model;

import net.lemnik.eodsql.ResultColumn;

/**
*/
public class Reply {

    private String id;
    private String commentid;
    private String reply;

    public String getReply() {
        return reply;
    }

    @ResultColumn( value = "reply" )
    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getId() {
        return id;
    }

    @ResultColumn( value = "id" )
    public void setId(String id) {
        this.id = id;
    }

    public String getCommentid() {
        return commentid;
    }

    @ResultColumn( value = "commentid" )
    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString(){
        return "{"+
                    "\"commentid\" :" +"\""+ getCommentid()+ "\""+","+"\"id\" :" +"\""+getId()+"\""+","+"\"reply\" :" +"\""+getReply()+"\""
                +"}";
    }
}
