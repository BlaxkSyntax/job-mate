package za.co.wethinkcode.app.model;

public class AuthenticUser {

    private String username;
    private String id;
    
    public String getId() {
        return id;
    }
    
    public void setId(String userid) {
        this.id = userid;
    }
    
    
    public String getUsername() {
        return username;
    }
    
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString(){
        return "{\"username\" :" +"\""+ getUsername()+"\""+","+"\"id\" :" +"\""+getId()+"\""+"}";
    }
}
